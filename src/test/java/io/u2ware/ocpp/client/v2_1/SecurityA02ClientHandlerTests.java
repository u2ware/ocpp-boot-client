package io.u2ware.ocpp.client.v2_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker; //-> 2
import io.u2ware.ocpp.v2_1.messaging.CSMS;
import io.u2ware.ocpp.v2_1.messaging.CSMSCommand;
import io.u2ware.ocpp.v2_1.messaging.CSMSCommandTemplate;
import io.u2ware.ocpp.v2_1.messaging.ChargingStation;
import io.u2ware.ocpp.v2_1.messaging.ChargingStationCommandTemplate; //-> 1

@SpringBootTest
class SecurityA02ClientHandlerTests {

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
		CSMS mockServer = new CSMS();
		CSMSCommandTemplate mockServerTemplate 
			= new CSMSCommandTemplate("mockServerTemplate", mockServer);
		mockServer.registerHandler(new SecurityA02ServerHandler(mockServerTemplate));

			
		MockWebSocketHandlerInvoker.of(ac)
			.connect(clientTemplate, mockServerTemplate); //-> 2
		
		Thread.sleep(1000);	

		/////////////////////////////////////
		// 
		/////////////////////////////////////
		mockServerTemplate.send(CSMSCommand.ALL.TriggerMessage.buildWith("A02"));
		Thread.sleep(1000);

	}
}
