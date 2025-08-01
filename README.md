# ocpp-boot-client
OCPP client implementation with spring-boot

# Usage  (Preparing)

```bash
./mvnw springboot:run
```

> http://localhost:8082


# @EnableOcppClient 

```java
@SpringBootApplication
@EnableOcppClient(                       //-> 3. 
    version = OCPPVersion.V2_1,          //-> 2. 
	uri = "ws://localhost:8081/yourocpp" //-> 1. 
)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```
1. URI. websocket URI of ocpp server 

2. versions. V2_1, V2_0_1, V1_6

3. [@EnableOcppClient]() automatically registers the following beans:


    * v2.1

	|beanName|beanClass|Description|
	|------|:---|---|
	|ocppOperations | [ChargingStation]()| An object that can offer and answer OCPP version 2.1 message.|
	|ocppTemplate | [ChargingStationCommandOperations]()| An object that can send a [ChargingStationCommand]().|
	|ocppInitializer | [ChargingStationInitializer]()| Scan for a [ChargingStationHandler]() that register it in [ChargingStation]().|


    * v2.0.1

	|beanName|beanClass|Description|
	|------|:---|---|
	|ocppOperations | [ChargingStation]()| An object that can offer and answer OCPP version 2.0.1 message.|
	|ocppTemplate | [ChargingStationCommandOperations]()| An object that can send a [ChargingStationCommand]().|
	|ocppInitializer | [ChargingStationInitializer]()| Scan for a [ChargingStationHandler]() that register it in [ChargingStation]().|


    * v1.6

	|beanName|beanClass|Description|
	|------|:---|---|
	|ocppOperations | [ChargePoint]()| An object that can offer and answer OCPP version 1.6 message.|
	|ocppTemplate | [ChargePointCommandOperations]() | An object that can send a [ChargePointCommand]().|
	|ocppInitializer | [ChargePointInitializer]()| Scan for a [ChargePointHandler]() that register it in [ChargePoint]().|



# Customize Handler   

If you want to customize a Handler, implement the corresponding client handler.

```java
import io.u2ware.ocpp.v2_1.exception.ErrorCodes; //-> 3.
import io.u2ware.ocpp.v2_1.handlers.DataTransfer.ChargingStationHandler; //-> 2.

@Component //-> 1.
public class DataTransfer implements ChargingStationHandler { //-> 2.

    @Override/** DataTransfer [1/4] */
    public DataTransferRequest sendDataTransferRequest(
        String id, Map<String, Object> req) {
        return DataTransferRequest.builder().build();
    }

    @Override/** DataTransfer [3/4] */
    public void receivedDataTransferResponse(
        String id, DataTransferResponse res, ErrorCode err) {
    }

    @Override/** DataTransfer [2/4] */
    public DataTransferResponse receivedDataTransferRequest(
        String id, DataTransferRequest req) {
        if(ObjectUtils.isEmpty(req)) { // your logic...
            throw ErrorCodes.GenericError.exception("your error message"); //-> 3.
        }
        return DataTransferResponse.builder().build();
    }

    @Override/** DataTransfer [4/4] */
    public void sendDataTransferResponse(
        String id, DataTransferResponse res, ErrorCode err) {
    }
}
```

```java
import io.u2ware.ocpp.v2_1.handlers.Heartbeat; //-> 2.
import io.u2ware.ocpp.v2_1.handlers.TransactionEvent; //-> 2.
import io.u2ware.ocpp.v2_1.messaging.ChargingStationCommandOperations; //-> 4.

@Component //-> 1.
public class MyCustomHandler implements      
    Heartbeat.ChargingStationHandler, //-> 2.
    TransactionEvent.ChargingStationHandler {  //-> 2.

    protected @Autowired ChargingStationCommandOperations operations; //-> 4.

    @Override
    public String[] features() {
        return new String[]{"MyCustomHandler"};
    }

    @Override/** MyCustomHandler [1/8]  */
    public HeartbeatRequest sendHeartbeatRequest(
        String id, Map<String, Object> req) {
        return HeartbeatRequest.builder().build();
    }

    @Override/** MyCustomHandler [3/8] */
    public void receivedHeartbeatResponse(
        String id, HeartbeatResponse res, ErrorCode err) {

        ChargingStationCommand command = 
            ChargingStationCommand.ALL.TransactionEvent.buildWith("MyCustomHandler");
            
        operations.send(command); //-> 4.            
    }

    @Override/** MyCustomHandler [5/8] */
    public TransactionEventRequest sendTransactionEventRequest(
        String id, Map<String, Object> req) {
        return TransactionEventRequest.builder().build();
    }

    @Override/** MyCustomHandler [7/8] */
    public void receivedTransactionEventResponse(
        String id, TransactionEventResponse res, ErrorCode err) {
    }
}
```

1. Declare @Component so that 'ocppInitializer' scans the beans.
2. Implement a Client Handler according to OCPP messages. 
3. <i>OCPP CALL ERROR</i> messages can be sent by throwing an error code. 
4. You can send other <i>OCPP CALL</i> messages using 'ocppTemplate'.


# Test without I/O

```java
import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker; //-> 2.
import io.u2ware.ocpp.v2_1.messaging.CSMSCommandTemplate; //-> 1.
import io.u2ware.ocpp.v2_1.messaging.ChargingStationCommandTemplate; 


@SpringBootTest
class ApplicationTests {

    protected @Autowired ApplicationContext ac;

    protected @Autowired ChargingStationCommandTemplate clientTemplate;

    @Test
    void context1Loads() throws Exception {

        /////////////////////////////////////
        // OCPP Client Test  without I/O
        /////////////////////////////////////
        CSMSCommandTemplate mockServerTemplate 
            = new CSMSCommandTemplate(); //-> 1.

        MockWebSocketHandlerInvoker.of(ac)
            .connect(clientTemplate, mockServerTemplate); //-> 2.

        Thread.sleep(1000);	

        /////////////////////////////////////
        // 
        /////////////////////////////////////
        clientTemplate.send(ChargingStationCommand.ALL.Heartbeat.buildWith("MyCustomHandler"));
        Thread.sleep(1000);
    }
}

```
1. Make mock server object.
2. Connecting mock object with your client bean. 


# Core Concept 
![OCPP-BOOT](./lib/core.png)

* v2.1

|participant|object|
|------|:---|
|CommandOperations |[CSMSCommandOperations]()  or [ChargingStationCommandOperations]() |
|Offer | [CSMSHandler]() or [ChargingStationHandler]() |
|Sender |[CSMS]() or [ChargingStation]() |
|Receiver |[CSMS]() or [ChargingStation]() |
|Answer | [CSMSHandler]() or [ChargingStationHandler]() |


* v2.0.1

|participant|object|
|------|:---|
|CommandOperations |[CSMSCommandOperations]()  or [ChargingStationCommandOperations]() |
|Offer | [CSMSHandler]() or [ChargingStationHandler]() |
|Sender |[CSMS]() or [ChargingStation]() |
|Receiver |[CSMS]() or [ChargingStation]() |
|Answer | [CSMSHandler]() or [ChargingStationHandler]() |


* v1.6

|participant|object|
|------|:---|
|CommandOperations |[CentralSystemCommandOperations]()  or [ChargePointCommandOperations]() |
|Offer | [CentralSystemHandler]() or [ChargePointHandler]() |
|Sender |[CentralSystem]() or [ChargePoint]() |
|Receiver |[CentralSystem]() or [ChargePoint]() |
|Answer | [CentralSystemHandler]() or [ChargePointHandler]() |







