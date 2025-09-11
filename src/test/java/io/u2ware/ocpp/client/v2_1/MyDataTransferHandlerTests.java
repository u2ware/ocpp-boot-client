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
import io.u2ware.ocpp.v2_1.messaging.ChargingStationSession; 


@SpringBootTest
class MyDataTransferHandlerTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;
	protected @Autowired(required = false) ChargingStationSession ocppSession;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v2.1)ChargingStationSession: "+ocppSession);
		if(ocppSession == null) return;


        /////////////////////////////////////
        // Mock Object
        /////////////////////////////////////
		CSMSSession mockSession 
			= new CSMSSession("mockSession"); //-> 1.
		
		MockWebSocketHandlerInvoker.of(ac)
			.connect(ocppSession, mockSession); //-> 2
		
		Thread.sleep(1000);	


        /////////////////////////////////////
        // Test without I/O
        /////////////////////////////////////
        ChargingStationCommand command 
            = ChargingStationCommand.ALL.DataTransfer.build();
        ocppSession.offer(command); //-> 3

        Thread.sleep(1000);
	}
}
