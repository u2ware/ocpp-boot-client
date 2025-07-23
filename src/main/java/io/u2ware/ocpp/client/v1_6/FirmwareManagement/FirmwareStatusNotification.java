package io.u2ware.ocpp.client.v1_6.FirmwareManagement;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.FirmwareStatusNotification.ClientHandler;

@Component
public class FirmwareStatusNotification implements ClientHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public FirmwareStatusNotificationRequest sendFirmwareStatusNotificationRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendFirmwareStatusNotificationRequest, id));
        return FirmwareStatusNotificationRequest.builder().build();
    }

    @Override
    public void receivedFirmwareStatusNotificationResponse(String id, FirmwareStatusNotificationResponse res,
            ErrorCode err) {
        logger.info(comment(this, Comment.receivedFirmwareStatusNotificationResponse, id));
    }
}
