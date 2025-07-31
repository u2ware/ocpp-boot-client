package io.u2ware.ocpp.client.v1_6;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.exception.ErrorCodes; // 3.
import io.u2ware.ocpp.v1_6.handlers.Heartbeat;
import io.u2ware.ocpp.v1_6.handlers.RemoteStartTransaction; // 2.
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandOperations; // 4.
import io.u2ware.ocpp.v1_6.model.HeartbeatRequest;
import io.u2ware.ocpp.v1_6.model.HeartbeatResponse;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionResponse;

@Component // 1.
public class MyCustomHandler implements 
    RemoteStartTransaction.ChargePointHandler, // 2.
    Heartbeat.ChargePointHandler {  // 2.

    protected @Autowired ChargePointCommandOperations operations;

    @Override
    public String[] features() {
        return new String[]{"MyCustomHandler"};
    }

    @Override/** MyCustomHandler [1/8]  */
    public HeartbeatRequest sendHeartbeatRequest(
        String id, Map<String, Object> req) {
        return HeartbeatRequest.builder().build();
    }

    @Override/** MyCustomHandler [3/8] */
    public void receivedHeartbeatResponse(
        String id, HeartbeatResponse res, ErrorCode err) {
    }

    @Override/** MyCustomHandler [6/8] */
    public RemoteStartTransactionResponse receivedRemoteStartTransactionRequest(
        String id, RemoteStartTransactionRequest req) {
        if(ObjectUtils.isEmpty(req)) {
            throw ErrorCodes.GenericError.exception("your error message"); // 3.
        }            
        return RemoteStartTransactionResponse.builder().build();        
    }

    @Override/** MyCustomHandler [8/8] */
    public void sendRemoteStartTransactionResponse(
        String id, RemoteStartTransactionResponse res, ErrorCode err) {

        ChargePointCommand command = 
            ChargePointCommand.Core.StartTransaction.build();            

        operations.send(command); // 4.
    }
}