package io.u2ware.ocpp.client.v1_6;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.config.WebSocketHandlerInvoker;
import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandTemplate;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OCPPApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;

	protected @Autowired ChargePoint client;
	protected @Autowired ChargePointCommandTemplate clientTemplate;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v1.6)ChargePoint               : "+client);
		logger.info("(v1.6)ChargePointCommandTemplate: "+clientTemplate);
	}
}
