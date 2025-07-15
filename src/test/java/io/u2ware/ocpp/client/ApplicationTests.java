package io.u2ware.ocpp.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

// import static io.u2ware.common.docs.MockMvcRestDocs.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	protected Log logger = LogFactory.getLog(getClass());

    
    private @LocalServerPort int port;

	@Test
	void contextLoads() throws Exception {






		
	}
}
