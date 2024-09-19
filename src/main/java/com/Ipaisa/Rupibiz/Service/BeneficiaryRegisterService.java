package com.Ipaisa.Rupibiz.Service;

import java.io.IOException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Ipaisa.Rupibiz.Entity.BeneficiaryRegisterRequest;
import com.Ipaisa.Rupibiz.dto.BeneficiaryRegisterDto;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class BeneficiaryRegisterService {
	public static final Logger Logger=LoggerFactory.getLogger(BeneficiaryRegisterService.class);

	 @Value("${rupeebiz.api.token}")
	    private String apiToken;

	    private final OkHttpClient client = new OkHttpClient();
	    private final String URL = "https://api.rupeebiz.com/ws/dmr5/beneficiary_register";

	    public String sendBeneficiaryRegisterRequest(BeneficiaryRegisterDto brr) throws IOException {
	    	System.out.println(brr.toString());
	        // Static data to be sent in the request
	        JSONObject jsonPayload = new JSONObject();
	        jsonPayload.put("apiToken", apiToken);  
	       // jsonPayload.put("format",brr.getFormat());
	        jsonPayload.put("mobile",brr.getMobile());
	        jsonPayload.put("bankid",brr.getBankid());
	        jsonPayload.put("beneficiary_name",brr.getBeneficiary_name());
	        jsonPayload.put("beneficiary_mobile",brr.getBeneficiary_mobile());
	        jsonPayload.put("beneficiary_ifsc",brr.getBeneficiary_ifsc());
	        jsonPayload.put("beneficiary_account_no",brr.getBeneficiary_account_no());
	        jsonPayload.put("outletid",brr.getOutletid());
	        
	       
	       
	       RequestBody formBody = new FormBody.Builder()
	        		.add("apiToken", apiToken)
	        		.add("format", "")
	        		.add("mobile",brr.getMobile())
	        		.add("bankid",brr.getBankid())
	        		.add("beneficiary_name",brr.getBeneficiary_name())
	        		.add("beneficiary_mobile",brr.getBeneficiary_mobile())
	        		.add("beneficiary_ifsc",brr.getBeneficiary_ifsc())
	        		.add("beneficiary_account_no",brr.getBeneficiary_account_no())
	        		.add("outletid",brr.getOutletid())
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
	           
	            
	            // Parse the response to check for beneficiary status
	            System.out.println("------------------------------");
//	            JSONObject responseJson = new JSONObject(responseBody);
	            
//	            System.out.println(""+responseJson);
//	            if (responseJson.has("beneficiary_status") && responseJson.getInt("beneficiary_status") == 0) {
//	                // OTP validation required
//	                String otpReference = responseJson.optString("otpReference"); // Assuming the response includes otpReference
//	                // Call validate OTP method with the details (you might need to collect OTP from user input)
//	                return validateBeneficiaryOtp(brr.getMobile(), otpReference, brr.getOtp());
//	            }

	            return responseBody;
	        }
	    }
	            
	 // Method to validate OTP (you may need to adjust parameters according to your actual implementation)
	    private String validateBeneficiaryOtp(String mobile, String otpReference, String otp) throws IOException {
	        // Create request body for OTP validation
	        RequestBody formBody = new FormBody.Builder()
	                .add("apiToken", apiToken)
	                .add("mobile", mobile)
	                .add("otpReference", otpReference)
	                .add("otp", otp) // Assuming OTP is captured from user input
	                .build();

	        // URL for OTP validation (assumed endpoint; replace with actual if different)
	        String validateOtpUrl = "https://api.rupeebiz.com/ws/ipaydmrv2/beneficiary_register_validate";

	        // Create the HTTP request for OTP validation
	        Request request = new Request.Builder()
	                .url(validateOtpUrl)
	                .post(formBody)
	                .build();

	        // Send the OTP validation request and capture the response
	        try (Response response = client.newCall(request).execute()) {
	            String responseBody = response.body().string();
	            // Log the response payload
	            Logger.info("OTP Validation Response Payload: " + responseBody);
	            return responseBody;
	        }
   
	           

}
}
