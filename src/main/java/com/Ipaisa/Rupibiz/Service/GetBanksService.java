package com.Ipaisa.Rupibiz.Service;

import java.io.IOException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Ipaisa.Rupibiz.Entity.GetBanksRequest;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


@Service
public class GetBanksService {

	  private static final Logger logger = LoggerFactory.getLogger(GetBanksService.class);

//	    @Value("${rupeebiz.api.url}")
//	    private String apiUrl;

	    @Value("${rupeebiz.api.token}")
	    private String apiToken;

	    private final OkHttpClient client = new OkHttpClient();
	    private final String URL = "https://api.rupeebiz.com/ws/ipaydmrv2/bank_details";
	    
	    
	    public String sendGetbanksRequest(GetBanksRequest gbr) throws IOException {
	        // Static data to be sent in the request
	        JSONObject jsonPayload = new JSONObject();
	        jsonPayload.put("apiToken", apiToken);  // API token included in the body
	        jsonPayload.put("format", gbr.getFormat());
	        jsonPayload.put("account", gbr.getAccount());
	        jsonPayload.put("outletid","5586");
	        
	        RequestBody formBody =new FormBody.Builder()
	        		.add("apiToken",apiToken)
	        		.add("format","")
	        		.add("account",gbr.getAccount())
	        		.add("outletid","5586")
	        		.build();
	        		
	        		
	        		        // Log the request payload
	        logger.info("Request Payload: " + jsonPayload.toString());

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
	            logger.info("Response Payload: " + responseBody);
	            return responseBody;
	        }
	    }
}
