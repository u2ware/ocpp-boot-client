package io.u2ware.ocpp.client.v1_6.Core;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.messaging.SpecificationAction;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.StartTransaction.ClientHandler;

@Component
public class StartTransaction implements ClientHandler {
    
    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired SpecificationSendingOperations ocppOperations;

    @Override
    public StartTransactionRequest sendStartTransactionRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendStartTransactionRequest, id));
        return StartTransactionRequest.builder().build(); 
    }

    @Override
    public void receivedStartTransactionResponse(String id, StartTransactionResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedStartTransactionResponse, id));

        if(! ObjectUtils.isEmpty(res)) {
            SpecificationAction action = Specification.InitiatedByChargePoint.DataTransfer.message(); 
            ocppOperations.convertAndSend(id, action);
        }
    }
}
