
package com.Ipaisa.Rupibiz.Service;

import java.io.IOException;
import java.security.SecureRandom;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class GetRechargeStatusService {
	  private static final Logger logger = LoggerFactory.getLogger(GetRechargeStatusService.class);

//    @Value("${rupeebiz.api.url}")
//    private String apiUrl;

    @Value("${rupeebiz.api.token}")
    private String apiToken;

    private final OkHttpClient client = new OkHttpClient();
    private final String URL = "https://api.rupeebiz.com/Apiservice.asmx/GetRechargeStatus_v2";
    
    
    private String generateReqId() {
        SecureRandom random = new SecureRandom();
        StringBuilder reqIdBuilder = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            reqIdBuilder.append(random.nextInt(10));  // Append random digits (0-9)
        }
        return reqIdBuilder.toString();
    }
 // Generate a new reqid
    String reqid = generateReqId();
    
    public String GetRechargeStatusRequest() throws IOException {
        // Static data to be sent in the request
        JSONObject jsonPayload = new JSONObject();
        jsonPayload.put("apiToken", apiToken);  // API token included in the body
       // jsonPayload.put("reqid", "1672291774");
        jsonPayload.put("reqid",reqid );
        jsonPayload.put("txndate", "2024-08-24");
        
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



