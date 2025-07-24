package io.u2ware.ocpp.client.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.GetConfiguration.ClientHandler;

@Component
public class GetConfiguration implements ClientHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public GetConfigurationResponse receivedGetConfigurationRequest(String id, GetConfigurationRequest req) {
        logger.info(comment(this, Comment.receivedGetConfigurationRequest, id));
        return GetConfigurationResponse.builder().build();
    }

    @Override
    public void sendGetConfigurationResponse(String id, GetConfigurationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendGetConfigurationResponse, id));
    }
}
