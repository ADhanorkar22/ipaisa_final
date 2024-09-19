
package com.Ipaisa.Rupibiz.Service;

import java.io.IOException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Ipaisa.Rupibiz.Entity.GetRemitterrransferLimitRequest;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class GetRemitterrransferLimitService {

	public static final Logger Logger=LoggerFactory.getLogger(GetRemitterrransferLimitService.class);

	 @Value("${rupeebiz.api.token}")
	    private String apiToken;

	    private final OkHttpClient client = new OkHttpClient();
	    private final String URL ="https://api.rupeebiz.com/ws/dmr5/getremitterrransferlimit";

	    public String sendGetRemitterrransferLimitRequest(GetRemitterrransferLimitRequest getremelimit) throws IOException {
	        //System.out.println("--"+rre);
	    	
	    	// Static data to be sent in the request
	        JSONObject jsonPayload = new JSONObject();
	        jsonPayload.put("apiToken", apiToken);  
	        jsonPayload.put("format","");
	        jsonPayload.put("mobile",getremelimit.getMobile());
	        jsonPayload.put("outletid","5586");
	        
	        
	        RequestBody formBody = new FormBody.Builder()
	                .add("apiToken", apiToken)  // Use the token from properties
	                .add("format", "")
	                .add("mobile", getremelimit.getMobile())
	                .add("outletid", "5586")
	                 .build();
	     
	        
	        
	        // Log the request payload
	        Logger.info("Request Payload: " + jsonPayload.toString());
System.out.println("-------->> "+jsonPayload);
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


