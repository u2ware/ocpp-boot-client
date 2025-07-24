package io.u2ware.ocpp.client.v1_6.SmartCharging;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.StatusNotification.ClientHandler;

@Component
public class StatusNotification implements ClientHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public StatusNotificationRequest sendStatusNotificationRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendStatusNotificationRequest, id));
        return StatusNotificationRequest.builder().build();
    }

    @Override
    public void receivedStatusNotificationResponse(String id, StatusNotificationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedStatusNotificationResponse, id));
    }
}
