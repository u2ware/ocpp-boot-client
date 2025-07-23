package io.u2ware.ocpp.client.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.ClearCache.ClientHandler;

@Component
public class ClearCache implements ClientHandler{

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public ClearCacheResponse receivedClearCacheRequest(String id, ClearCacheRequest req) {
        logger.info(comment(this, Comment.receivedClearCacheRequest, id));
        return ClearCacheResponse.builder().build();
    }

    @Override
    public void sendClearCacheResponse(String id, ClearCacheResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendClearCacheResponse, id));
    }    
}
