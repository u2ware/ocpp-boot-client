package io.u2ware.ocpp.client.v2_0_1;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v2_0_1.exception.*;
import io.u2ware.ocpp.v2_0_1.model.*;
import io.u2ware.ocpp.v2_0_1.usecase.A02.ClientHandler;

@Component
public class A02 implements ClientHandler{

    protected Log logger = LogFactory.getLog(getClass());

    @Override
    public TriggerMessageResponse receivedTriggerMessageRequest(String id, TriggerMessageRequest req) {
        logger.info(comment(this, Comment.receivedTriggerMessageRequest, id));
        return new TriggerMessageResponse();
    }

    @Override
    public void sendTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendTriggerMessageResponse, id));
    }

    @Override
    public SignCertificateRequest sendSignCertificateRequest(String id, Map<String,Object> req) {
        logger.info(comment(this, Comment.sendSignCertificateRequest, id));
        return new SignCertificateRequest();
    }
    @Override
    public void receivedSignCertificateResponse(String id, SignCertificateResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.receivedSignCertificateResponse, id));
    }

    @Override
    public CertificateSignedResponse receivedCertificateSignedRequest(String id, CertificateSignedRequest req) {
        logger.info(comment(this, Comment.receivedCertificateSignedRequest, id));
        return new CertificateSignedResponse();
    }

    @Override
    public void sendCertificateSignedResponse(String id, CertificateSignedResponse res, ErrorCode err) {
        logger.info(comment(this, Comment.sendCertificateSignedResponse, id));
    }            

}
