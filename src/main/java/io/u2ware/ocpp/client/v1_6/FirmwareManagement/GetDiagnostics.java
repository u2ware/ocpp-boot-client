package io.u2ware.ocpp.client.v1_6.FirmwareManagement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.SpecificationSendingOperations;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.GetDiagnostics.ClientHandler;

@Component
public class GetDiagnostics implements ClientHandler {

    protected Log logger = LogFactory.getLog(getClass());
    
    protected @Autowired(required = false) SpecificationSendingOperations ocppOperations;

    @Override
    public GetDiagnosticsResponse receivedGetDiagnosticsRequest(String id, GetDiagnosticsRequest req) {
        logger.info(comment(this, Comment.receivedGetDiagnosticsRequest, id));
        return new GetDiagnosticsResponse();
    }

    @Override
    public void sendGetDiagnosticsResponse(String id, GetDiagnosticsResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendGetDiagnosticsResponse, id));
    }

}