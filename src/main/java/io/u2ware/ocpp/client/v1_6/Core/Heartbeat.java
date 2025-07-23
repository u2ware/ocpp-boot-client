package io.u2ware.ocpp.client.v1_6.Core;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.Heartbeat.ClientHandler;

@Component
public class Heartbeat implements ClientHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public HeartbeatRequest sendHeartbeatRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendHeartbeatRequest, id));
        return HeartbeatRequest.builder().build();
    }

    @Override
    public void receivedHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedHeartbeatResponse, id));
    }
}
