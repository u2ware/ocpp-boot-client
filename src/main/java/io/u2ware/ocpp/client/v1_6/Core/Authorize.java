package io.u2ware.ocpp.client.v1_6.Core;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.Authorize.ClientHandler;

@Component
public class Authorize implements ClientHandler{

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public AuthorizeRequest sendAuthorizeRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendAuthorizeRequest, id));
        return AuthorizeRequest.builder().build();
    }

    @Override
    public void receivedAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedAuthorizeResponse, id));
    }  
}
