package io.u2ware.ocpp.client.v1_6.Reservation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.SetChargingProfile.ClientHandler;

@Component
public class SetChargingProfile implements ClientHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public SetChargingProfileResponse receivedSetChargingProfileRequest(String id, SetChargingProfileRequest req) {
        logger.info(comment(this, Comment.receivedSetChargingProfileRequest, id));
        return new SetChargingProfileResponse();
    }

    @Override
    public void sendSetChargingProfileResponse(String id, SetChargingProfileResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendSetChargingProfileResponse, id));
    }
}
