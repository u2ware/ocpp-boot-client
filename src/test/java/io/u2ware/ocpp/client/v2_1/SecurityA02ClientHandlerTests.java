package io.u2ware.ocpp.client.v2_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker; //-> 2
import io.u2ware.ocpp.v2_1.messaging.CSMSSession;
import io.u2ware.ocpp.v2_1.messaging.ChargingStationCommand;
import io.u2ware.ocpp.v2_1.messaging.ChargingStationSession;//-> 1

@SpringBootTest
class SecurityA02ClientHandlerTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;
	protected @Autowired(required = false) ChargingStationSession ocppSession;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v2.1)ChargingStationSession: "+ocppSession);
		if(ocppSession == null) return;

			
        /////////////////////////////////////
        // Test without I/O
        /////////////////////////////////////
		CSMSSession mockSession 
			= new CSMSSession("mockServerTemplate", false);
		mockSession.actor().registerHandler(new SecurityA02ServerHandler(mockSession));

			
		MockWebSocketHandlerInvoker.of(ac)
			.connect(ocppSession, mockSession); //-> 2
		
		Thread.sleep(1000);	

		/////////////////////////////////////
		// 
		/////////////////////////////////////
		ocppSession.offer(ChargingStationCommand.ALL.SignCertificate.buildWith("A02"));
		Thread.sleep(1000);

	}
}
