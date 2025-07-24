package io.u2ware.ocpp.client;

import org.springframework.context.annotation.Configuration;

import io.u2ware.ocpp.config.EnableOcppClient;
import io.u2ware.ocpp.core.OCPPVersion;

@Configuration
@EnableOcppClient(version = OCPPVersion.V1_6, uri="ws://localhost:8081/ocpp")
// @EnableOcppClient(version = OCPPVersion.V2_0_1, uri="ws://localhost:8081/ocpp")
// @EnableOcppClient(version = OCPPVersion.V2_1, uri="ws://localhost:8081/ocpp")
public class OCPPConfig {
    
}
