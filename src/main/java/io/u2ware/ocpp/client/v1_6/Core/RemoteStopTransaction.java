package io.u2ware.ocpp.client.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.RemoteStopTransaction.ClientHandler;

@Component
public class RemoteStopTransaction implements ClientHandler {
    
    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public RemoteStopTransactionResponse receivedRemoteStopTransactionRequest(String id,
            RemoteStopTransactionRequest req) {
        logger.info(comment(this, Comment.receivedRemoteStopTransactionRequest, id));
        return RemoteStopTransactionResponse.builder().build();
    }

    @Override
    public void sendRemoteStopTransactionResponse(String id, RemoteStopTransactionResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendRemoteStopTransactionResponse, id));
    }
}
