package io.u2ware.ocpp.client.v1_6;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import io.u2ware.ocpp.client.MockWebSocketHandlerInvoker;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemTransport;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointTransport;


@SpringBootTest
class MyDataTransferHandlerTests {

	protected Log logger = LogFactory.getLog(getClass());

  	protected @Autowired ApplicationContext ac;

	protected @Autowired(required = false) ChargePointTransport ocppTransport;


	@Test
	void context1Loads() throws Exception {

		logger.info("(v1.6)ChargePointTransport: "+ocppTransport);
		if(ocppTransport == null) return;

		/////////////////////////////////////
		// OCPP Client Test without I/O
		/////////////////////////////////////
		CentralSystemTransport mockTransport = new CentralSystemTransport("mockTransport");
		MockWebSocketHandlerInvoker.of(ac).connect(ocppTransport, mockTransport);
		Thread.sleep(1000);	


		/////////////////////////////////////
		// 
		/////////////////////////////////////
		ocppTransport.offer(ChargePointCommand.Core.DataTransfer.build());
		Thread.sleep(1000);		
	}
}
