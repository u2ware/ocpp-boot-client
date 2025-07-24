package io.u2ware.ocpp.client.v2_0_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.u2ware.ocpp.config.EnableOcppClient;
import io.u2ware.ocpp.core.OCPPVersion;


@SpringBootApplication
@EnableOcppClient(version = OCPPVersion.V2_0_1, uri="ws://localhost:8081/ocpp")
public class OCPPApplication {

	public static void main(String[] args) {
		SpringApplication.run(OCPPApplication.class, args);
	}

}
