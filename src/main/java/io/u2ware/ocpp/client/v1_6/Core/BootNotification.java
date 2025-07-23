package io.u2ware.ocpp.client.v1_6.Core;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.BootNotification.ClientHandler;

@Component
public class BootNotification implements ClientHandler{

    protected Log logger = LogFactory.getLog(getClass());

    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public BootNotificationRequest sendBootNotificationRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendBootNotificationRequest, id));
        return BootNotificationRequest.builder().build();
    }

    @Override
    public void receivedBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedBootNotificationResponse, id));
    } 
        
}
