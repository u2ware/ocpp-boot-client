package io.u2ware.ocpp.client.connect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.core.OCPPWebsocketTemplate.WebSocketSessionConnectEvent;
import io.u2ware.ocpp.core.OCPPWebsocketTemplate.WebSocketSessionDisconnectEvent;

@Component
public class OcppConnectionHandler {
    
	protected Log logger = LogFactory.getLog(getClass());


    @EventListener
    public void handle(WebSocketSessionConnectEvent e) {
        logger.info("OcppConnectionHandler StandardSessionConnectEvent: ");
    }

    @EventListener
    public void handle(WebSocketSessionDisconnectEvent e) {
        logger.info("OcppConnectionHandler StandardSessionDisconnectEvent: ");
    }
}
