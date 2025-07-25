package io.u2ware.ocpp.client.v1_6.Core;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.MeterValues.ClientHandler;

@Component
public class MeterValues implements ClientHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public MeterValuesRequest sendMeterValuesRequest(String id, Map<String, Object> req) {
        logger.info(comment(this, Comment.sendMeterValuesRequest, id));
        return MeterValuesRequest.builder().build();
    }

    @Override
    public void receivedMeterValuesResponse(String id, MeterValuesResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedMeterValuesResponse, id));
    }
}
