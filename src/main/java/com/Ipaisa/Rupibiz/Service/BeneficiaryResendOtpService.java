package com.Ipaisa.Rupibiz.Service;

import java.io.IOException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Ipaisa.Rupibiz.Entity.BeneficiaryResendOtpRequest;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class BeneficiaryResendOtpService {
	public static final Logger Logger=LoggerFactory.getLogger(BeneficiaryResendOtpService.class);

	 @Value("${rupeebiz.api.token}")
	    private String apiToken;

	    private final OkHttpClient client = new OkHttpClient();
	    private final String URL = "https://api.rupeebiz.com/ws/ipaydmrv2/beneficiary_resend_otpr";

	    public String sendBeneficiaryResendOtpRequest(BeneficiaryResendOtpRequest brotp) throws IOException {
	        // Static data to be sent in the request
	        JSONObject jsonPayload = new JSONObject();
	        jsonPayload.put("apiToken", apiToken);  
	        jsonPayload.put("format",brotp.getFormat());
	      
	       jsonPayload.put("remitter_id",brotp.getRemitter_id());
	       jsonPayload.put("benificiary_id",brotp.getBenficiary_id());
	       jsonPayload.put("outletid",brotp.getOutletid());
	       
	       RequestBody formBody = new FormBody.Builder()
	        		.add("apiToken", " ")
	        		.add("format", " ")
	        		.add("remitter_id", brotp.getRemitter_id())
	        		.add("beneficiary_id", brotp.getBenficiary_id() )
	        		.add("outletid",brotp.getOutletid())
	        		
	        		.build();
	       
	       
	       
	       
	        // Log the request payload
	        Logger.info("Request Payload: " + jsonPayload.toString());

	        // Create request body
	        RequestBody body = RequestBody.create(jsonPayload.toString(), MediaType.get("application/json; charset=utf-8"));

	        // Create HTTP request (no token in the header)
	        Request request = new Request.Builder()
	                .url(URL)
	                .post(formBody)
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
