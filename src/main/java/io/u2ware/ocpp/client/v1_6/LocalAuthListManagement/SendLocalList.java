package io.u2ware.ocpp.client.v1_6.LocalAuthListManagement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.SendLocalList.ClientHandler;

@Component
public class SendLocalList implements ClientHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public SendLocalListResponse receivedSendLocalListRequest(String id, SendLocalListRequest req) {
        logger.info(comment(this, Comment.receivedSendLocalListRequest, id));
        return SendLocalListResponse.builder().build();
    }

    @Override
    public void sendSendLocalListResponse(String id, SendLocalListResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendSendLocalListResponse, id));
    }
}
