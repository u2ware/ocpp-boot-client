# ocpp-boot-client
OCPP client implementation with spring-boot

# Usage

```bash
./mvnw springboot:run
```

> http://localhost:8082


# @EnableOcppClient 

```java
@SpringBootApplication
@EnableOcppClient(                       //-> 3. 
    version = OCPPVersion.V1_6,          //-> 2. 
	uri = "ws://localhost:8081/yourocpp" //-> 1. 
)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```
1. URI. websocket URI of ocpp server 

2. version. V1_6, V2_0_1, V2_1

3. '@EnableOcppClient' automatically registers the following beans:

    * v1.6

	|beanName|beanClass|Description|
	|------|:---|---|
	|ocppOperations | [ChargePoint]()| An object that can offer and answer OCPP version 1.6 message.|
	|ocppTemplate | [ChargePointCommandOperations]() | An object that can send a [ChargePointCommand]().|
	|ocppInitializer | [ChargePointInitializer]()| Scan for a [ChargePointHandler]() that register it in [ChargePoint]().|


    * v2.0.1

	|beanName|beanClass|Description|
	|------|:---|---|
	|ocppOperations | [ChargingStation]()| An object that can offer and answer OCPP version 2.0.1 message.|
	|ocppTemplate | [ChargingStationCommandOperations]()| An object that can send a [ChargingStationCommand]().|
	|ocppInitializer | [ChargingStationInitializer]()| Scan for a [ChargingStationHandler]() that register it in [ChargingStation]().|

    * v2.1

	|beanName|beanClass|Description|
	|------|:---|---|
	|ocppOperations | [ChargingStation]()| An object that can offer and answer OCPP version 2.1 message.|
	|ocppTemplate | [ChargingStationCommandOperations]()| An object that can send a [ChargingStationCommand]().|
	|ocppInitializer | [ChargingStationInitializer]()| Scan for a [ChargingStationHandler]() that register it in [ChargingStation]().|


# Customize Handler   

If you want to customize a Handler, implement the corresponding client handler.

```java
import io.u2ware.ocpp.v1_6.exception.ErrorCodes; // 3.
import io.u2ware.ocpp.v1_6.handlers.DataTransfer.ChargePointHandler; // 2.

@Component // 1.
public class DataTransfer implements ChargePointHandler { // 2.

    protected Log logger = LogFactory.getLog(getClass());

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
        if(ObjectUtils.isEmpty(req)) {
            throw ErrorCodes.GenericError.exception("your error message"); // 3.
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
import io.u2ware.ocpp.v1_6.handlers.Heartbeat; // 2.
import io.u2ware.ocpp.v1_6.handlers.StartTransaction; // 2.
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandOperations; // 4.

@Component // 1.
public class MyCustomHandler implements      
    Heartbeat.ChargePointHandler, // 2.
    StartTransaction.ChargePointHandler {  // 2.

    protected @Autowired ChargePointCommandOperations operations;

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
        ChargePointCommand command = 
            ChargePointCommand.Core.StartTransaction.buildWith("MyCustomHandler");
        operations.send(command); // 4.            
    }

    @Override/** MyCustomHandler [5/8] */
    public StartTransactionRequest sendStartTransactionRequest(
        String id, Map<String, Object> req) {
        return StartTransactionRequest.builder().build();
    }

    @Override/** MyCustomHandler [7/8] */
    public void receivedStartTransactionResponse(
        String id, StartTransactionResponse res, ErrorCode err) {
    }
}
```

1. Declare @Component so that 'ocppInitializer' scans the beans.
2. Implement a Client Handler according to OCPP messages. 
3. <i>OCPP CALL ERROR</i> messages can be sent by throwing an error code. 
4. You can send other <i>OCPP CALL</i> messages using 'ocppTemplate'.


# Test without I/O (preparing)









