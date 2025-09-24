package io.u2ware.ocpp.client.v2_1;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.u2ware.ocpp.v2_1.messaging.CSMSTransport;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.handlers.CertificateSigned;
import io.u2ware.ocpp.v2_1.handlers.SignCertificate;
import io.u2ware.ocpp.v2_1.handlers.TriggerMessage;
import io.u2ware.ocpp.v2_1.messaging.CSMSCommand;
import io.u2ware.ocpp.v2_1.model.CertificateSignedRequest;
import io.u2ware.ocpp.v2_1.model.CertificateSignedResponse;
import io.u2ware.ocpp.v2_1.model.SignCertificateRequest;
import io.u2ware.ocpp.v2_1.model.SignCertificateResponse;
import io.u2ware.ocpp.v2_1.model.TriggerMessageRequest;
import io.u2ware.ocpp.v2_1.model.TriggerMessageResponse;

public class SecurityA02ServerHandler  implements 
    TriggerMessage.CSMSHandler,
    SignCertificate.CSMSHandler, //-> 2.
    CertificateSigned.CSMSHandler //-> 2.
    {

    protected Log logger = LogFactory.getLog(getClass());

    protected CSMSTransport ocppTransport;

    public SecurityA02ServerHandler(CSMSTransport ocppTransport){
        this.ocppTransport = ocppTransport;
    }

    @Override
    public String usecase() {
        return "A02";
    }

    @Override
    public TriggerMessageRequest sendTriggerMessageRequest(String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\t TriggerMessage[1/4] sendTriggerMessageRequest(%s)\n", id));
        return TriggerMessageRequest.builder().build();
    }   


    @Override
    public void receivedTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t TriggerMessage[3/4] receivedTriggerMessageResponse(%s)\n", id));
    }


    @Override
    public SignCertificateResponse receivedSignCertificateRequest(String id, SignCertificateRequest req) {
        logger.info(String.format("\n\n\t SignCertificate[2/4] receivedSignCertificateRequest(%s)\n", id));
        return SignCertificateResponse.builder().build();
    }

    @Override
    public void sendSignCertificateResponse(String id, SignCertificateResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t SignCertificate[4/4] sendSignCertificateResponse(%s)\n", id));

        CSMSCommand command = 
            CSMSCommand.ALL.CertificateSigned.buildWith(usecase());
        ocppTransport.offer(command, id); //-> 4.
    }

    @Override
    public CertificateSignedRequest sendCertificateSignedRequest(String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\t CertificateSigned[1/4] sendCertificateSignedRequest(%s)\n", id));
        return CertificateSignedRequest.builder().build();
    }  

    @Override
    public void receivedCertificateSignedResponse(String id, CertificateSignedResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\t CertificateSigned[3/4] receivedCertificateSignedResponse(%s)\n", id));
    }
}
