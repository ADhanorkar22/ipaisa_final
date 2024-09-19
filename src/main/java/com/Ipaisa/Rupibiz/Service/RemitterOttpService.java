package com.Ipaisa.Rupibiz.Service;
import okhttp3.*;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
@Service
public class RemitterOttpService {
	
	
	    private static final Logger logger = LoggerFactory.getLogger(RemitterService.class);
	    @Value("${rupeebiz.api.token}")
	    private String apiToken;
//	    @Value("${rupeebiz.api.format}")
//	    private String format;
	    private final OkHttpClient client = new OkHttpClient();
	    private final String REMITTER_URL = "https://api.rupeebiz.com/ws/ipaydmrv2/remitter";
	    private final String REMITTER_VALIDATE_URL = "https://api.rupeebiz.com/ws/ipaydmrv2/remitter_validate";
	    // Function to register remitter
	    public JSONObject registerRemitter(String mobile, String name, String surname, String pincode) throws IOException {
	        RequestBody formBody = new FormBody.Builder()
	                .add("apiToken", apiToken)
	               // .add("format", format)
	                .add("mobile", mobile)
	                .add("name", name)
	                .add("surname", surname)
	                .add("pincode", pincode)
	                .build();
	        Request request = new Request.Builder()
	                .url(REMITTER_URL)
	                .post(formBody)
	                .build();
	        try (Response response = client.newCall(request).execute()) {
	            String responseBody = response.body().string();
	            logger.info("Remitter Registration Response: " + responseBody);
	            System.out.println(responseBody);
	            return new JSONObject(responseBody);
	        }
	    }
	    // Function to validate remitter with OTP
	    public String validateRemitter(String mobile, String remitterId, String otp) throws IOException {
	        RequestBody formBody = new FormBody.Builder()
	                .add("apiToken", apiToken)
	            //    .add("format", format)
	                .add("mobile", mobile)
	                .add("remitter_id", remitterId)
	                .add("otp", otp)
	                .build();
	        Request request = new Request.Builder()
	                .url(REMITTER_VALIDATE_URL)
	                .post(formBody)
	                .build();
	        try (Response response = client.newCall(request).execute()) {
	            String responseBody = response.body().string();
	            logger.info("Remitter Validation Response: " + responseBody);
	            System.out.println(responseBody);
	            return responseBody;
	        }
	    }
	}


