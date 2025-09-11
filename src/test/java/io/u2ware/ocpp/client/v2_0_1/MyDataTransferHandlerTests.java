package io.u2ware.ocpp.client.v2_0_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.v2_0_1.messaging.ChargingStationCommand;
import io.u2ware.ocpp.v2_0_1.messaging.CSMSSession;
import io.u2ware.ocpp.v2_0_1.messaging.ChargingStationSession;


@SpringBootTest
class MyDataTransferHandlerTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;
	protected @Autowired(required = false) ChargingStationSession ocppSession;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v2.0.1)ChargingStationSession: "+ocppSession);
		if(ocppSession == null) return;
	
		/////////////////////////////////////
		// OCPP Client Test  without I/O
		/////////////////////////////////////
		CSMSSession mockSession = new CSMSSession("mockSession");
		MockWebSocketHandlerInvoker.of(ac).connect(ocppSession, mockSession);
		Thread.sleep(1000);	


		/////////////////////////////////////
		// 
		/////////////////////////////////////
		ocppSession.offer(ChargingStationCommand.ALL.DataTransfer.build());
		Thread.sleep(1000);			

	}
}
