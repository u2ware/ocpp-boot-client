package io.u2ware.ocpp.client.v1_6.LocalAuthListManagement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.GetLocalListVersion.ClientHandler;

@Component
public class GetLocalListVersion implements ClientHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public GetLocalListVersionResponse receivedGetLocalListVersionRequest(String id,
            GetLocalListVersionRequest req) {
        logger.info(comment(this, Comment.receivedGetLocalListVersionRequest, id));
        return GetLocalListVersionResponse.builder().build();
    }

    @Override
    public void sendGetLocalListVersionResponse(String id, GetLocalListVersionResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendGetLocalListVersionResponse, id));
    }
}
