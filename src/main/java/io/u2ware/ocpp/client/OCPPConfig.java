package io.u2ware.ocpp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.u2ware.ocpp.config.EnableOcppClient;
import io.u2ware.ocpp.config.OcppAttributes;
import io.u2ware.ocpp.OCPPVersion;

@Configuration
@EnableOcppClient(version = OCPPVersion.V2_1, uri="ws://localhost:8081/ocpp")
// @EnableOcppClient(version = OCPPVersion.V2_0_1, uri="ws://localhost:8081/ocpp")
// @EnableOcppClient(version = OCPPVersion.V1_6, uri="ws://localhost:8081/ocpp")
public class OCPPConfig implements WebMvcConfigurer{
    

    @Autowired
    protected OcppAttributes ocppAttributes;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        String console = ocppAttributes.getOcppBootConsole();
        String viewName = String.format("redirect:%s", console);
        registry.addViewController("/").setViewName(viewName);
    }    


}
