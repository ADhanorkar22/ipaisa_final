package com.Ipaisa.Rupibiz.Service;

import org.springframework.stereotype.Service;
import okhttp3.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.security.SecureRandom;


@Service
public class RegisterComplaintService {
	 private static final Logger logger = LoggerFactory.getLogger(RegisterComplaintService.class);

	   

	    @Value("${rupeebiz.api.token}")
	    private String apiToken;

	    private final OkHttpClient client = new OkHttpClient();
	    private final String URL = "https://api.rupeebiz.com/apiservice.asmx/RegisterComplaint";

	    
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
	    
	    
	    
	    
	    public String sendRechargeRequest() throws IOException {
	        // Static data to be sent in the request
	        JSONObject jsonPayload = new JSONObject();
	        jsonPayload.put("apiToken", apiToken); 
	        jsonPayload.put("reqid",reqid );
	      //  jsonPayload.put("reqid","1672291774");
	        jsonPayload.put("reason", "");
	        
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



