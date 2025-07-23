package io.u2ware.ocpp.client.v1_6.RemoteTrigger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.CancelReservation.ClientHandler;

@Component
public class CancelReservation implements ClientHandler{
    
    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public CancelReservationResponse receivedCancelReservationRequest(String id, CancelReservationRequest req) {
        logger.info(comment(this, Comment.receivedCancelReservationRequest, id));
        return CancelReservationResponse.builder().build();
    }

    @Override
    public void sendCancelReservationResponse(String id, CancelReservationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendCancelReservationResponse, id));

    }    
}
