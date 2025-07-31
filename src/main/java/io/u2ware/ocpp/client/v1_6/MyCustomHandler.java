package io.u2ware.ocpp.client.v1_6;


import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.handlers.Heartbeat; // 2.
import io.u2ware.ocpp.v1_6.handlers.StartTransaction; // 2.
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandOperations; // 4.
import io.u2ware.ocpp.v1_6.model.HeartbeatRequest;
import io.u2ware.ocpp.v1_6.model.HeartbeatResponse;
import io.u2ware.ocpp.v1_6.model.StartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StartTransactionResponse;

@Component // 1.
public class MyCustomHandler implements      
    Heartbeat.ChargePointHandler, // 2.
    StartTransaction.ChargePointHandler {  // 2.

    protected Log logger = LogFactory.getLog(getClass());

    protected @Autowired ChargePointCommandOperations operations;

    @Override
    public String[] features() {
        return new String[]{"MyCustomHandler"};
    }

    @Override/** MyCustomHandler [1/8]  */
    public HeartbeatRequest sendHeartbeatRequest(
        String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\t MyCustomHandler[1/8] sendHeartbeatRequest(%s)\n", id));
        return HeartbeatRequest.builder().build();
    }

    @Override/** MyCustomHandler [3/8] */
    public void receivedHeartbeatResponse(
        String id, HeartbeatResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t MyCustomHandler[3/8] receivedHeartbeatResponse(%s)\n", id));
        ChargePointCommand command = 
            ChargePointCommand.Core.StartTransaction.buildWith("MyCustomHandler");
        operations.send(command); // 4.            
    }

    @Override/** MyCustomHandler [5/8] */
    public StartTransactionRequest sendStartTransactionRequest(
        String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\t MyCustomHandler[5/8] sendStartTransactionRequest(%s)\n", id));
        return StartTransactionRequest.builder().build();
    }

    @Override/** MyCustomHandler [7/8] */
    public void receivedStartTransactionResponse(
        String id, StartTransactionResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t MyCustomHandler[7/8] receivedStartTransactionResponse(%s)\n", id));
    }
}