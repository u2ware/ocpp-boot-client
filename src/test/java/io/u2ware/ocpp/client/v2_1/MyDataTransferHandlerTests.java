package io.u2ware.ocpp.client.v2_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker; //-> 2
import io.u2ware.ocpp.v2_1.messaging.CSMSTransport;
import io.u2ware.ocpp.v2_1.messaging.ChargingStationCommand;
import io.u2ware.ocpp.v2_1.messaging.ChargingStationTransport; 


@SpringBootTest
class MyDataTransferHandlerTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;
	protected @Autowired(required = false) ChargingStationTransport ocppTransport;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v2.1)ChargingStationTransport: "+ocppTransport);
		if(ocppTransport == null) return;


        /////////////////////////////////////
        // Mock Object
        /////////////////////////////////////
		CSMSTransport mockTransport 
			= new CSMSTransport("mockTransport"); //-> 1.
		
		MockWebSocketHandlerInvoker.of(ac)
			.connect(ocppTransport, mockTransport); //-> 2
		
		Thread.sleep(1000);	


        /////////////////////////////////////
        // Test without I/O
        /////////////////////////////////////
        ChargingStationCommand command 
            = ChargingStationCommand.ALL.DataTransfer.build();
        ocppTransport.offer(command); //-> 3

        Thread.sleep(1000);
	}
}
