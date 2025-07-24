package io.u2ware.ocpp.client.v1_6.SmartCharging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.TriggerMessage.ClientHandler;

@Component
public class TriggerMessage implements ClientHandler {
    
    protected Log logger = LogFactory.getLog(getClass());

    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public TriggerMessageResponse receivedTriggerMessageRequest(String id, TriggerMessageRequest req) {
        logger.info(comment(this, Comment.receivedTriggerMessageRequest, id));
        return new TriggerMessageResponse();
    }

    @Override
    public void sendTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendTriggerMessageResponse, id));
    }
}
