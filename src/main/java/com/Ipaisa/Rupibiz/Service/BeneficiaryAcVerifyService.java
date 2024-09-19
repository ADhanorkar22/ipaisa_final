package com.Ipaisa.Rupibiz.Service;

import java.io.IOException;
import java.security.SecureRandom;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Ipaisa.Rupibiz.Entity.BeneficiaryAcVerifyRequest;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class BeneficiaryAcVerifyService {
	public static final Logger Logger=LoggerFactory.getLogger(BeneficiaryAcVerifyService.class);

	 @Value("${rupeebiz.api.token}")
	    private String apiToken;

	    private final OkHttpClient client = new OkHttpClient();
	    private final String URL = "https://api.rupeebiz.com/ws/mobile/v5/Recharge";

	    
	    private String generateReqId() {
	        SecureRandom random = new SecureRandom();
	        StringBuilder reqIdBuilder = new StringBuilder(10);
	        for (int i = 0; i < 10; i++) {
	            reqIdBuilder.append(random.nextInt(10));  // Append random digits (0-9)
	        }
	        return reqIdBuilder.toString();
	    }

	    
	    
	    
	    
	    public String sendBeneficiaryAcVerifyRequest(BeneficiaryAcVerifyRequest  bacr) throws IOException {
	        // Static data to be sent in the request
	    	
	    	
	    	  String reqid = generateReqId();

	    	
	    	
	        JSONObject jsonPayload = new JSONObject();
	        jsonPayload.put("apiToken", apiToken);  
	        jsonPayload.put("mn",bacr.getMn());
	        jsonPayload.put("op",bacr.getOp());
	        jsonPayload.put("amt",bacr.getAmt());
	        jsonPayload.put("reqid",reqid);
	        jsonPayload.put("bankAccNo",bacr.getBankAccNo());
	        jsonPayload.put("ifscCode",bacr.getIfscCode());
	        	       
	       RequestBody formbody = new FormBody.Builder()
	                .add("apiToken", apiToken)
	                .add("mn", bacr.getMn())
	                .add("op", bacr.getOp())
	                .add("amt", bacr.getAmt())
	                .add("reqid",reqid )
	                .add("bankAccNo", bacr.getBankAccNo())
	                .add("ifscCode", bacr.getIfscCode())
	                .build();

	       
	        // Log the request payload
	        Logger.info("Request Payload: " + jsonPayload.toString());

	        // Create request body
	        RequestBody body = RequestBody.create(jsonPayload.toString(), MediaType.get("application/json; charset=utf-8"));

	        // Create HTTP request (no token in the header)
	        Request request = new Request.Builder()
	                .url(URL)
	                .post(formbody)
	                .build();

	        // Send the request and capture the response
	        try (Response response = client.newCall(request).execute()) {
	            String responseBody = response.body().string();
	            // Log the response payload
	            Logger.info("Response Payload: " + responseBody);
	            return responseBody;
	        }
	    }
}
