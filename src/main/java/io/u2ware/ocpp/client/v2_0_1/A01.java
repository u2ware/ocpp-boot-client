package io.u2ware.ocpp.client.v2_0_1;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v2_0_1.exception.*;
import io.u2ware.ocpp.v2_0_1.model.*;
import io.u2ware.ocpp.v2_0_1.usecase.A01.ClientHandler;

@Component
public class A01 implements ClientHandler{
    
    protected Log logger = LogFactory.getLog(getClass());

    @Override
    public SetVariablesResponse receivedSetVariablesRequest(String id, SetVariablesRequest req) {
        logger.info(comment(this, Comment.receivedSetVariablesRequest, id));
        return new SetVariablesResponse();
    }

    @Override
    public void sendSetVariablesResponse(String id, SetVariablesResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendSetVariablesResponse, id));
    }    
}