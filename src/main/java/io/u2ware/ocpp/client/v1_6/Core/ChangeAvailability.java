package io.u2ware.ocpp.client.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.ChangeAvailability.ClientHandler;

@Component
public class ChangeAvailability implements ClientHandler{
    
    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public ChangeAvailabilityResponse receivedChangeAvailabilityRequest(String id,
            ChangeAvailabilityRequest req) {
        logger.info(comment(this, Comment.receivedChangeAvailabilityRequest, id));
        return ChangeAvailabilityResponse.builder().build();
    }

    @Override
    public void sendChangeAvailabilityResponse(String id, ChangeAvailabilityResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendChangeAvailabilityResponse, id));

    }    
}
