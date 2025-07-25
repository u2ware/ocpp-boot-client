package io.u2ware.ocpp.client.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.exception.ErrorCodes;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.RemoteStartTransaction.ClientHandler;

@Component
public class RemoteStartTransaction implements ClientHandler {
    
    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public RemoteStartTransactionResponse receivedRemoteStartTransactionRequest(String id,
            RemoteStartTransactionRequest req) {
        logger.info(comment(this, Comment.receivedRemoteStartTransactionRequest, id));
        if(ObjectUtils.isEmpty(req)) {
            throw ErrorCodes.GenericError.exception("your error message"); // 4
        }
        return RemoteStartTransactionResponse.builder().build();
    }

    @Override
    public void sendRemoteStartTransactionResponse(String id, RemoteStartTransactionResponse res,
            ErrorCode err) {
        logger.info(comment(this, Comment.sendRemoteStartTransactionResponse, id), err);
    }
}
