# ocpp-boot-client
OCPP client implementation with spring-boot

## Requriement (preparing)

ocpp-boot 



## Usage (preparing)

```bash
./mvnw springboot:run
```

Admin UI
http://localhost:8082

# @EnableOcppClient (preparing)

```java
@SpringBootApplication
@EnableOcppClient(                      //-> (1) 
    version = OCPPVersion.V1_6,         //-> (2) 
	uri = "ws://localhost:8081/myocpp" //-> (3) 
)
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```
(1) Enable Ocpp Client annotation 

(2) version. V1_6, V2_0_1, V2_1

(3) URI. websocket URI of ocpp server 


# OCPP Specification (preparing)

If you want to customize a Usecase, implement the corresponding client handler.

```java


```

# Test without I/O (preparing)







