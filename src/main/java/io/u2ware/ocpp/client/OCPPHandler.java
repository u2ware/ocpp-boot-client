package io.u2ware.ocpp.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.OCPPSessionConnectEvent;
import io.u2ware.ocpp.OCPPSessionDisconnectEvent;
import io.u2ware.ocpp.OCPPSessionErrorEvent;
import io.u2ware.ocpp.OCPPSessionReceivedEvent;
import io.u2ware.ocpp.OCPPSessionSendEvent;


@Component
public class OCPPHandler {
    
	protected Log logger = LogFactory.getLog(getClass());


    @EventListener
    public void handle(OCPPSessionConnectEvent e) {
        logger.info("CONNECT: ");
    }

    @EventListener
    public void handle(OCPPSessionDisconnectEvent e) {
        logger.info("DISCONNECT: ");
    }

    @EventListener
    public void handle(OCPPSessionSendEvent e) {
        logger.info("SEND: "+e.getPayload());
    }

    @EventListener
    public void handle(OCPPSessionReceivedEvent e) {
        logger.info("RECEIVED: "+e.getPayload());
    }

    @EventListener
    public void handle(OCPPSessionErrorEvent e) {
        logger.info(e.getPayload(), e.getException());
    }
}
