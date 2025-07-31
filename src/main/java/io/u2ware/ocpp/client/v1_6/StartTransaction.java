package io.u2ware.ocpp.client.v1_6;

import java.util.Map;

import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.handlers.StartTransaction.ChargePointHandler; // 2.
import io.u2ware.ocpp.v1_6.model.StartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StartTransactionResponse;

@Component // 1.
public class StartTransaction implements ChargePointHandler { // 2.

    @Override/** StartTransaction [1/4] */
    public StartTransactionRequest sendStartTransactionRequest(
        String id, Map<String, Object> req) {
        return StartTransactionRequest.builder().build();
    } 

    @Override/** StartTransaction [3/4] */
    public void receivedStartTransactionResponse(
        String id, StartTransactionResponse res, ErrorCode err) {        
    }
}
