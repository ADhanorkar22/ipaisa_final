package com.Ipaisa.Rupibiz.Service;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Ipaisa.Rupibiz.Entity.BillFetchRequest;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class BillFetchService {
	  private static final Logger logger = LoggerFactory.getLogger(BillFetchService.class);

//    @Value("${rupeebiz.api.url}")
//    private String apiUrl;

    @Value("${rupeebiz.api.token}")
    private String apiToken;

    private final OkHttpClient client = new OkHttpClient();
    private final String URL = "https://api.rupeebiz.com/ws/viewBill?apiToken=&mn=&op=&reqid=1724483567&field1&field2&field3&field4&field5&field6&field7&field8&field9&field10&custmn";

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

    
    public String sendRechargeRequest(Map<String, String> parameters ) throws IOException {
        // Static data to be sent in the request
//        JSONObject jsonPayload = new JSONObject();

    	BillFetchRequest bfr=new BillFetchRequest(parameters.get("mn"),parameters.get("op"),parameters.get("amt"),reqid,parameters.get("custmn"));
    	
    	 
    	 String op=bfr.getOp();
    	 String mn=bfr.getMn();
    	 String amt=bfr.getAmt();
    //	 String reqid=bfr.getReqid();
    	 String field1=bfr.getField1();
    	 String field2=bfr.getField2();
    	 String field3=bfr.getField3();
    	 String field4=bfr.getField4();
    	 String field5=bfr.getField5();
    	 String field6=bfr.getField6();
    	 String field7=bfr.getField7();
    	 String field8=bfr.getField8();
    	 String field9=bfr.getField9();
    	 String field10=bfr.getField10();
         String custmn=bfr.getCustmn();
    	    	 
    	 
    	 
           	 // Log the request payload
    	    logger.info("Request Payload: apiToken=" + apiToken + ", mn=" + mn + ", op=" + op + ", amt=" + amt + ", reqid=" + reqid + ", custmn=" + custmn );
    	    
    	    // Build the URL with query parameters
    	    //HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.rupeebiz.com/ws/viewBill?apiToken=&mn=&op=&reqid=1724483567&field1&field2&field3&field4&field5&field6&field7&field8&field9&field10&custmn")
    	    	//	("https://example.com/recharge") // Replace with the actual endpoint URL
    	    HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.rupeebiz.com/ws/viewBill")    	    	      
    	    .newBuilder()
    	            .addQueryParameter("apiToken", apiToken)
    	            .addQueryParameter("mn", mn)
    	            .addQueryParameter("op", op)
    	            .addQueryParameter("amt", amt)
    	            .addQueryParameter("reqid", reqid)
    	            .addQueryParameter("field1", field1)
    	            .addQueryParameter("field2", field2)
    	            .addQueryParameter("field3", field3)
    	            .addQueryParameter("field4", field4)
    	            .addQueryParameter("field5", field5)
    	            .addQueryParameter("field6", field6)
    	            .addQueryParameter("field7", field7)
    	            .addQueryParameter("field8", field8)
    	            .addQueryParameter("field9", field9)
    	            .addQueryParameter("field10", field10)
    	            .addQueryParameter("custmn", custmn);
    	            

    	    // Build the final URL
    	    String url = urlBuilder.build().toString();

    	    // Log the final URL
    	 //   logger.info("Request URL: " + url);
        

        // Create request body
     //   RequestBody body = RequestBody.create(jsonPayload.toString(), MediaType.get("application/json; charset=utf-8"));

        // Create HTTP request (no token in the header)
        Request request = new Request.Builder()
                .url(URL)
             //   .post(body)
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