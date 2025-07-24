package io.u2ware.ocpp.client.v1_6.FirmwareManagement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.UpdateFirmware.ClientHandler;

@Component
public class UpdateFirmware implements ClientHandler {
    
    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public UpdateFirmwareResponse receivedUpdateFirmwareRequest(String id, UpdateFirmwareRequest req) {
        logger.info(comment(this, Comment.receivedUpdateFirmwareRequest, id));
        return UpdateFirmwareResponse.builder().build();
    }

    @Override
    public void sendUpdateFirmwareResponse(String id, UpdateFirmwareResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendUpdateFirmwareResponse, id));
    }
}
