
package com.Ipaisa.Rupibiz.Service;

import java.io.IOException;
import java.security.SecureRandom;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Ipaisa.Rupibiz.Entity.DTHRecharge;
import com.Ipaisa.Rupibiz.Repo.DTHRechargeRepo;
import com.Ipaisa.Rupibiz.dto.ReachargeDetailsParameters;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


@Service
public class RechargeDTHService {
    private static final Logger logger = LoggerFactory.getLogger(RechargeService.class);
//    @Value("${rupeebiz.api.url}")
//    private String apiUrl;
   
    
    @Autowired
    private DTHRechargeRepo repo;
    @Value("${rupeebiz.api.token}")
    private String apiToken;
    
    private final OkHttpClient client = new OkHttpClient();
    private final String URL = "https://api.rupeebiz.com/apiservice.asmx/Recharge_v3";
    
    
    @Autowired
    public RechargeDTHService(DTHRechargeRepo rechargedthrepo) {
    	this.repo= rechargedthrepo;
    }
    
    
    
    
    
    private String generateReqId() {
        SecureRandom random = new SecureRandom();
        StringBuilder reqIdBuilder = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            reqIdBuilder.append(random.nextInt(10));  // Append random digits (0-9)
        }
        return reqIdBuilder.toString();
    }
    public String sendRechargeRequestt(ReachargeDetailsParameters rr) throws IOException {
        // Static data to be sent in the request
    	//System.out.println(rr.getProviderName());
    	DTHRecharge provider = this.repo.findByProviderName(rr.getProviderName());
    	System.out.println(provider.toString());
    	
    	
    	String reqid = generateReqId();
    	
    	System.out.println("this is reqid---"+reqid);
    	
    	
        JSONObject jsonPayload = new JSONObject();
        jsonPayload.put("apiToken", apiToken);  // API token included in the body
        jsonPayload.put("mn", rr.getMn());
        jsonPayload.put("op", provider.getOpcode());
        jsonPayload.put("amt", rr.getAmt());
        jsonPayload.put("reqid", reqid);
        jsonPayload.put("field1","");
        jsonPayload.put("field2", "");
        jsonPayload.put("field3", "");
        jsonPayload.put("field4", "");
        jsonPayload.put("field5", "");
        jsonPayload.put("field6", "");
        jsonPayload.put("field7", "");
        jsonPayload.put("field8", "");
        jsonPayload.put("field9", "");
        jsonPayload.put("field10", "");
        jsonPayload.put("custmn", rr.getMn());
        jsonPayload.put("isasync", "false");
        
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



