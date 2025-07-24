package io.u2ware.ocpp.client.v2_0_1;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v2_0_1.exception.*;
import io.u2ware.ocpp.v2_0_1.model.*;
import io.u2ware.ocpp.v2_0_1.usecase.A05.ClientHandler;

@Component
public class A05 implements ClientHandler{
    
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

    @Override
    public ResetResponse receivedResetRequest(String id, ResetRequest req) {
        logger.info(comment(this, Comment.receivedResetRequest, id));
        return new ResetResponse();
    }

    @Override
    public void sendResetResponse(String id, ResetResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendResetResponse, id));
    }

    @Override
    public BootNotificationRequest sendBootNotificationRequest(String id, Map<String,Object> req) {
        logger.info(comment(this, Comment.sendBootNotificationRequest, id));
        return new BootNotificationRequest();
    }

    @Override
    public void receivedBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedBootNotificationResponse, id));
    }
}
