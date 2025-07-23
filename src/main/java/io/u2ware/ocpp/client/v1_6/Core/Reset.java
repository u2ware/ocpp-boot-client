package io.u2ware.ocpp.client.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.Reset.ClientHandler;

@Component
public class Reset implements ClientHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public ResetResponse receivedResetRequest(String id, ResetRequest req) {
        logger.info(comment(this, Comment.receivedResetRequest, id));
        return ResetResponse.builder().build();
    }

    @Override
    public void sendResetResponse(String id, ResetResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendResetResponse, id));
    }
}
