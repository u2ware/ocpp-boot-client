package io.u2ware.ocpp.client.v1_6.RemoteTrigger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.ReserveNow.ClientHandler;

@Component
public class ReserveNow implements ClientHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public ReserveNowResponse receivedReserveNowRequest(String id, ReserveNowRequest req) {
        logger.info(comment(this, Comment.receivedReserveNowRequest, id));
        return ReserveNowResponse.builder().build();
    }

    @Override
    public void sendReserveNowResponse(String id, ReserveNowResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendReserveNowResponse, id));
    }

}
