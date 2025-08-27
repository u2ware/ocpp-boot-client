package io.u2ware.ocpp.client.v2_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker; //-> 2
import io.u2ware.ocpp.v2_1.messaging.CSMSCommandTemplate; //-> 1
import io.u2ware.ocpp.v2_1.messaging.ChargingStation;
import io.u2ware.ocpp.v2_1.messaging.ChargingStationCommand;
import io.u2ware.ocpp.v2_1.messaging.ChargingStationCommandTemplate; 


@SpringBootTest
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;

	protected @Autowired(required = false) ChargingStation client;
	protected @Autowired(required = false) ChargingStationCommandTemplate clientTemplate;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v2.1)ChargingStation               : "+client);
		logger.info("(v2.1)ChargingStationCommandTemplate: "+clientTemplate);
		if(client == null || clientTemplate == null) return;


        /////////////////////////////////////
        // Test without I/O
        /////////////////////////////////////
		CSMSCommandTemplate mockServerTemplate 
			= new CSMSCommandTemplate("mockServerTemplate");
		
		MockWebSocketHandlerInvoker.of(ac)
			.connect(clientTemplate, mockServerTemplate); //-> 2
		Thread.sleep(1000);	


		/////////////////////////////////////
		// 
		/////////////////////////////////////
		clientTemplate.send(ChargingStationCommand.ALL.Heartbeat.buildWith("MyCustomHandler"));
		Thread.sleep(10000);			

	}
}
