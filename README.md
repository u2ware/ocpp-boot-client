# ocpp-boot-client
OCPP client implementation with spring-boot

# Requriement

```xml
<dependency>
	<groupId>io.u2ware</groupId>
	<artifactId>ocpp-boot</artifactId>
	<version>0.9.9</version>
</dependency>
```
   
> [ocpp-boot](https://github.com/u2ware/ocpp-boot?tab=readme-ov-file#install) 
    

# Usage

```bash
./mvnw springboot:run
```

> http://localhost:8082


# @EnableOcppClient 

```java
@SpringBootApplication
@EnableOcppClient(                      //-> (1) 
    version = OCPPVersion.V1_6,         //-> (2) 
	uri = "ws://localhost:8081/yourocpp"  //-> (3) 
)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```
1. '@EnableOcppClient' automatically registers the following beans:

	|beanName|Description|
	|------|:---|
	|ocppOperations|[SpecificationOperations]() object that matches the version.|
	|ocppTemplate|[SpecificationSendingOperations]() object that matches the version.|
	|ocppInitializer|Scan for a Handler that matches the version and register it in [SpecificationOperations]().|

2. version. V1_6, V2_0_1, V2_1
3. URI. websocket URI of ocpp server 


# Customize Usecase   

If you want to customize a Usecase, implement the corresponding client handler.

```java
import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.exception.ErrorCodes;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.messaging.SpecificationAction;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.usecase.StartTransaction.ClientHandler; 

@Component // 1
public class StartTransaction implements ClientHandler { // 2
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public StartTransactionRequest sendStartTransactionRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendStartTransactionRequest, id));
        return StartTransactionRequest.builder().build(); 
    }

    @Override
    public void receivedStartTransactionResponse(String id, StartTransactionResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedStartTransactionResponse, id), err);

        if(! ObjectUtils.isEmpty(res)) {
            SpecificationAction action = Specification.InitiatedByChargePoint.DataTransfer.message();  // 3
            ocppOperations.convertAndSend(id, action);
        }
    }
}
```

```java
@Component // 1
public class RemoteStartTransaction implements ClientHandler { // 2
    
    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public RemoteStartTransactionResponse receivedRemoteStartTransactionRequest(String id,
            RemoteStartTransactionRequest req) {
        logger.info(comment(this, Comment.receivedRemoteStartTransactionRequest, id));
        if(ObjectUtils.isEmpty(req)) {
            throw ErrorCodes.GenericError.exception("your error message"); // 4
        }
        return RemoteStartTransactionResponse.builder().build();
    }

    @Override
    public void sendRemoteStartTransactionResponse(String id, RemoteStartTransactionResponse res,
            ErrorCode err) {
        logger.info(comment(this, Comment.sendRemoteStartTransactionResponse, id), err);
    }
}
```

1. Declare @Component so that 'ocppInitializer' scans the beans.
2. Implement a Client Handler according to OCPP messages. 
3. You can send other OCPP CALL messages using [SpecificationSendingOperations]().
4. OCPP CALL-ERROR messages can be sent by throwing an error code. 


# Test without I/O (preparing)







