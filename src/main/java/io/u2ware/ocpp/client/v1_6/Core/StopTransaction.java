package io.u2ware.ocpp.client.v1_6.Core;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.StopTransaction.ClientHandler;

@Component
public class StopTransaction implements ClientHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;


    @Override
    public StopTransactionRequest sendStopTransactionRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendStopTransactionRequest, id));
        return StopTransactionRequest.builder().build();
    }

    @Override
    public void receivedStopTransactionResponse(String id, StopTransactionResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedStopTransactionResponse, id));
    }
}
