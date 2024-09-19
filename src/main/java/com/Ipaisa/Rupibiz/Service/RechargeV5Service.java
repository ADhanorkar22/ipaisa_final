package com.Ipaisa.Rupibiz.Service;

import java.io.IOException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Ipaisa.Rupibiz.Entity.RechargeV5Request;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class RechargeV5Service {

	  private static final Logger logger = LoggerFactory.getLogger(RechargeV5Service.class);

//    @Value("${rupeebiz.api.url}")
//    private String apiUrl;

    @Value("${rupeebiz.api.token}")
    private String apiToken;

    private final OkHttpClient client = new OkHttpClient();
    private final String URL = "https://api.rupeebiz.com/apiservice.asmx/Recharge_v5";

    
    
    public String sendRechargeRequest(RechargeV5Request rrv) throws IOException {
        // Static data to be sent in the request
        JSONObject jsonPayload = new JSONObject();
        jsonPayload.put("apiToken", apiToken);  // API token included in the body
        jsonPayload.put("mn", rrv.getMn());
        jsonPayload.put("op", rrv.getOp());
        jsonPayload.put("amt", rrv.getAmt());
        jsonPayload.put("reqid", rrv.getReqid());
        jsonPayload.put("field1", rrv.getField1());
        jsonPayload.put("field2", rrv.getField2());
        jsonPayload.put("field3", rrv.getField3());
        jsonPayload.put("field4", rrv.getField4());
        jsonPayload.put("field5", rrv.getField5());
        jsonPayload.put("field6",rrv.getField6());
        jsonPayload.put("field7", rrv.getField7());
        jsonPayload.put("field8", rrv.getField8());
        jsonPayload.put("field9", rrv.getField9());
        jsonPayload.put("field10", rrv.getField10());
        jsonPayload.put("custmn", rrv.getCustmn());
        jsonPayload.put("isasync", rrv.getIsasync());
        
        
        jsonPayload.put("viewbillresponse","{\\\"success\\\":\\\"true\\\",\\\"data\\\":[{\\\"dueDate\\\":\\\"\\\",\\\"billAmount\\\":\\\"0\\\",\\\"statusMessage\\\":1,\\\"acceptPayment\\\":\\\"true\\\",\\\"acceptPartPay\\\":\\\"true\\\",\\\"maxBillAmount\\\":\\\"\\\",\\\"customername\\\":\\\"\\\",\\\"billnumber\\\":\\\"\\\",\\\"billdate\\\":\\\"\\\",\\\"billperiod\\\":\\\"\\\",\\\"AddInfo\\\":[],\\\"paymentAmountExactness\\\":null}]}");
        // Log the request payload
        logger.info("Request Payload: " + jsonPayload.toString());

        // Create request body
        RequestBody body = RequestBody.create(jsonPayload.toString(), MediaType.get("application/json; charset=utf-8"));

        // Create HTTP request (no token in the header)
        Request request = new Request.Builder()
                .url(URL)
                .post(body)
                .build();

        // Send the request and capture the response
        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            // Log the response payload
            logger.info("Response Payload: " + responseBody);
            return responseBody;
        }
    }
}

	

