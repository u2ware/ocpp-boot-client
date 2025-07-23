package io.u2ware.ocpp.client.v1_6.Reservation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.ClearChargingProfile.ClientHandler;

@Component
public class ClearChargingProfile implements ClientHandler{

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public ClearChargingProfileResponse receivedClearChargingProfileRequest(String id, ClearChargingProfileRequest req) {
        logger.info(comment(this, Comment.receivedClearChargingProfileRequest, id));
        return ClearChargingProfileResponse.builder().build();
    }

    @Override
    public void sendClearChargingProfileResponse(String id, ClearChargingProfileResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendBootNotificationRequest, id));
    }    
}
