package io.u2ware.ocpp.client.v1_6.FirmwareManagement;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.DiagnosticsStatusNotification.ClientHandler;

@Component
public class DiagnosticsStatusNotification implements ClientHandler{
    
    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public DiagnosticsStatusNotificationRequest sendDiagnosticsStatusNotificationRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendDiagnosticsStatusNotificationRequest, id));
        return DiagnosticsStatusNotificationRequest.builder().build();
    }

    @Override
    public void receivedDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedDiagnosticsStatusNotificationResponse, id));
    }
}
