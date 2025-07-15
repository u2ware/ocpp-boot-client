package io.u2ware.ocpp.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.u2ware.ocpp.config.EnableOcppClient;
import io.u2ware.ocpp.core.OCPPVersion;

@SpringBootApplication
@EnableOcppClient(version = OCPPVersion.V1_6, uri="ws://localhost:8080/ocpp", allowDefaultUsecase = true)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
