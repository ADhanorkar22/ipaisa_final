package com.Ipaisa.Rupibiz.Service;

import java.io.IOException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Ipaisa.Rupibiz.Entity.RemitterRequest;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class RemitterService {

	public static final Logger Logger=LoggerFactory.getLogger(RemitterService.class);

	 @Value("${rupeebiz.api.token}")
	    private String apiToken;

	    private final OkHttpClient client = new OkHttpClient();
	    private final String URL ="https://api.rupeebiz.com/ws/ipaydmr/remitter";

	    public String sendRemitterRequest(RemitterRequest rre) throws IOException {
	        System.out.println("--"+rre);
	    	
	    	// Static data to be sent in the request
	        JSONObject jsonPayload = new JSONObject();
	        jsonPayload.put("apiToken", apiToken);  
	        jsonPayload.put("format","");
	        jsonPayload.put("mobile","9769725979");
	        jsonPayload.put("name",rre.getName());
	        jsonPayload.put("surname",rre.getSurname());
	        jsonPayload.put("pincode",rre.getPincode());
	        jsonPayload.put("outledid", "5586");
	        jsonPayload.put("addressline1",rre.getAddressline1());
	        jsonPayload.put("addressline2",rre.getAddressline2());
	        jsonPayload.put("area",rre.getArea());
            jsonPayload.put("city",rre.getCity());
            jsonPayload.put("district",rre.getDistrict());
            jsonPayload.put("state",rre.getState());
            jsonPayload.put("country",rre.getCountry());
            jsonPayload.put("dob",rre.getDob());
            

	        
	        RequestBody formBody = new FormBody.Builder()
	                .add("apiToken", apiToken)  // Use the token from properties
	                .add("format", "")
	                .add("mobile", rre.getMobile())
	                .add("name", rre.getName())
	                .add("surname", rre.getSurname())
	                .add("pincode", rre.getPincode())
	                .add("outletid","5586")
	                .add("addressline1",rre.getAddressline1())
	                .add("addressline2",rre.getAddressline2())
	                .add("area",rre.getArea())
	                .add("city",rre.getCity())
	                .add("district",rre.getDistrict())
	                .add("state",rre.getState())
	                .add("country",rre.getCountry())
	                .add("dob",rre.getDob())
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


