package io.u2ware.ocpp.client.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.UnlockConnector.ClientHandler;

@Component
public class UnlockConnector implements ClientHandler {

    protected Log logger = LogFactory.getLog(getClass());

    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public UnlockConnectorResponse receivedUnlockConnectorRequest(String id, UnlockConnectorRequest req) {
        logger.info(comment(this, Comment.receivedUnlockConnectorRequest, id));
        return UnlockConnectorResponse.builder().build();
    }

    @Override
    public void sendUnlockConnectorResponse(String id, UnlockConnectorResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendUnlockConnectorResponse, id));
    }
}
