package io.u2ware.ocpp.client.v2_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.u2ware.ocpp.config.EnableOcppClient;
import io.u2ware.ocpp.OCPPVersion;


@SpringBootApplication
@EnableOcppClient(version = OCPPVersion.V2_1, uri="ws://localhost:8081/ocpp")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
