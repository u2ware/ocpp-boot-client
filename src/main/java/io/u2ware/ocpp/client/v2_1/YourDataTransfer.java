package io.u2ware.ocpp.client.v2_1;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.exception.ErrorCodes; //-> 3.
import io.u2ware.ocpp.v2_1.handlers.DataTransfer.ChargingStationHandler; //-> 1.
import io.u2ware.ocpp.v2_1.model.DataTransferRequest;
import io.u2ware.ocpp.v2_1.model.DataTransferResponse;

@Component
public class YourDataTransfer implements ChargingStationHandler { //-> 1.

    protected Log logger = LogFactory.getLog(getClass());

   @Override
    public String usecase() {
        return "Your";
    }

    @Override
    public Boolean actions() {
        return Boolean.FALSE;
    }


    @Override/** DataTransfer [1/4] */
    public DataTransferRequest sendDataTransferRequest(
        String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\t YourDataTransfer[1/4] sendDataTransferRequest(%s)\n", id));
        return DataTransferRequest.builder().data("client").build();
    }

    @Override/** DataTransfer [3/4] */
    public void receivedDataTransferResponse(
        String id, DataTransferResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t YourDataTransfer[3/4] receivedDataTransferResponse(%s)\n", id));
    }

    @Override/** DataTransfer [2/4] */
    public DataTransferResponse receivedDataTransferRequest(
        String id, DataTransferRequest req) {
        logger.info(String.format("\n\n\t YourDataTransfer[2/4] receivedDataTransferRequest(%s)\n", id));
        if(ObjectUtils.isEmpty(req)) {  // your logic...
            throw ErrorCodes.GenericError.exception("your error message"); //-> 3.
        }
        return DataTransferResponse.builder().data("client").build();
    }

    @Override/** DataTransfer [4/4] */
    public void sendDataTransferResponse(
        String id, DataTransferResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t YourDataTransfer[4/4] sendDataTransferResponse(%s)\n", id));
    }
}
