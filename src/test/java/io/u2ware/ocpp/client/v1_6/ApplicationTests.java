package io.u2ware.ocpp.client.v1_6;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandTemplate;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandTemplate;


@SpringBootTest
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;

	protected @Autowired ChargePoint client;
	protected @Autowired ChargePointCommandTemplate clientTemplate;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v1.6)ChargePoint               : "+client);
		logger.info("(v1.6)ChargePointCommandTemplate: "+clientTemplate);

		/////////////////////////////////////
		// OCPP Client Test without I/O
		/////////////////////////////////////
		CentralSystemCommandTemplate mockServerTemplate = new CentralSystemCommandTemplate("mockServerTemplate");
		MockWebSocketHandlerInvoker.of(ac).connect(clientTemplate, mockServerTemplate);
		Thread.sleep(1000);	


		/////////////////////////////////////
		// 
		/////////////////////////////////////
		clientTemplate.send(ChargePointCommand.Core.Heartbeat.buildWith("MyCustomHandler"));
		Thread.sleep(1000);		
	}
}
