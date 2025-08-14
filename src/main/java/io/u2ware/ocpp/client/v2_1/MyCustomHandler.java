package io.u2ware.ocpp.client.v2_1;


import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.handlers.Heartbeat; //-> 2.
import io.u2ware.ocpp.v2_1.handlers.TransactionEvent; //-> 2.
import io.u2ware.ocpp.v2_1.messaging.ChargingStationCommand;
import io.u2ware.ocpp.v2_1.messaging.ChargingStationCommandOperations; //-> 4.
import io.u2ware.ocpp.v2_1.model.HeartbeatRequest;
import io.u2ware.ocpp.v2_1.model.HeartbeatResponse;
import io.u2ware.ocpp.v2_1.model.TransactionEventRequest;
import io.u2ware.ocpp.v2_1.model.TransactionEventResponse;

@Component("MyCustomHandler_v2_1") //-> 1.
public class MyCustomHandler implements      
    Heartbeat.ChargingStationHandler, //-> 2.
    TransactionEvent.ChargingStationHandler {  //-> 2.

    protected Log logger = LogFactory.getLog(getClass());

    protected @Autowired(required = false) ChargingStationCommandOperations operations; //-> 4.

    @Override
    public String usecase() {
        return "MyCustomHandler";
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
        ChargingStationCommand command = 
            ChargingStationCommand.ALL.TransactionEvent.buildWith("MyCustomHandler");

        operations.send(id, command); //-> 4.            
    }

    @Override/** MyCustomHandler [5/8] */
    public TransactionEventRequest sendTransactionEventRequest(
        String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\t MyCustomHandler[5/8] sendTransactionEventRequest(%s)\n", id));
        return TransactionEventRequest.builder().build();
    }

    @Override/** MyCustomHandler [7/8] */
    public void receivedTransactionEventResponse(
        String id, TransactionEventResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t MyCustomHandler[7/8] receivedTransactionEventResponse(%s)\n", id));
    }
}