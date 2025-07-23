package io.u2ware.ocpp.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.config.WebSocketHandlerInvoker;
import io.u2ware.ocpp.v1_6.messaging.CentralSystem;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingTemplate;

// import static io.u2ware.common.docs.MockMvcRestDocs.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;

	protected @Autowired ChargePoint client;
	protected @Autowired SpecificationSendingTemplate clientTemplate;


	@Test
	void context1Loads() throws Exception {

		CentralSystem server = new CentralSystem();
		server.registerDefaultUsecases();
		SpecificationSendingTemplate serverTemplate = new SpecificationSendingTemplate(server);

		logger.info("===================");			
		WebSocketHandlerInvoker.of(ac).connect(serverTemplate, clientTemplate);
		Thread.sleep(2000);

		logger.info("2===================");			
		for(Specification s : Specification.usecases(client)) {
			clientTemplate.convertAndSend(s.message());
			Thread.sleep(500);
		}	

		logger.info("3===================");			
		for(Specification s : Specification.usecases(server)) {
			serverTemplate.convertAndSend(s.message());
			Thread.sleep(500);
		}
	}
}
