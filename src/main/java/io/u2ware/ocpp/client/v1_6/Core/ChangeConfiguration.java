package io.u2ware.ocpp.client.v1_6.Core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.ChangeConfiguration.ClientHandler;

@Component
public class ChangeConfiguration implements ClientHandler{

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public ChangeConfigurationResponse receivedChangeConfigurationRequest(String id,
            ChangeConfigurationRequest req) {
        logger.info(comment(this, Comment.receivedChangeConfigurationRequest, id));
        return ChangeConfigurationResponse.builder().build();

    }

    @Override
    public void sendChangeConfigurationResponse(String id, ChangeConfigurationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendChangeConfigurationResponse, id));

    }    
}
