package io.u2ware.ocpp.client.v2_0_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.v2_0_1.messaging.CSMSCommandTemplate;
import io.u2ware.ocpp.v2_0_1.messaging.ChargingStation;
import io.u2ware.ocpp.v2_0_1.messaging.ChargingStationCommand;
import io.u2ware.ocpp.v2_0_1.messaging.ChargingStationCommandTemplate;


@SpringBootTest
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;

	protected @Autowired ChargingStation client;
	protected @Autowired ChargingStationCommandTemplate clientTemplate;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v2.0.1)ChargingStation               : "+client);
		logger.info("(v2.0.1)ChargingStationCommandTemplate: "+clientTemplate);
	
		/////////////////////////////////////
		// OCPP Client Test  without I/O
		/////////////////////////////////////
		CSMSCommandTemplate mockServerTemplate = new CSMSCommandTemplate("mockServerTemplate");
		MockWebSocketHandlerInvoker.of(ac).connect(clientTemplate, mockServerTemplate);
		Thread.sleep(1000);	


		/////////////////////////////////////
		// 
		/////////////////////////////////////
		clientTemplate.send(ChargingStationCommand.ALL.Heartbeat.buildWith("MyCustomHandler"));
		Thread.sleep(1000);			

	}
}
