package com.Ipaisa.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Ipaisa.Repository.InstantPayoutRepository;
import com.Ipaisa.Repository.UserRepositery;
import com.Ipaisa.dto.TransactionStatusRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
@Transactional
public class InstantPauTxnStsSchedule {

	
	 @Value("${instantpay.client_id}")
	    private String Client_Id;

	    @Value("${instantpay.client_secret}")
	    private String Client_Secret;

	    @Autowired
	    private HttpServletRequest request;
	    @Autowired
	   	private UserRepositery uRepo;
	    
	    @Autowired
	    private InstantPayoutRepository instantPayoutService;
	
	    private final OkHttpClient client = new OkHttpClient();
	    private final ObjectMapper objectMapper = new ObjectMapper();
	    
	public String checkTransactionStatus(TransactionStatusRequestDTO dto) throws IOException {
   	 
    	// Endpoint URL
    	
    	
        String curl = "https://api.instantpay.in/reports/txnStatus";

    	URL url = new URL("http://ifconfig.me/ip");
    	HttpURLConnection con = (HttpURLConnection) url.openConnection();
    	con.setRequestMethod("GET");
    	BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    	String endpointIp = in.readLine();
    	in.close();
    	System.out.println("Public IP Address: " + endpointIp);
        // Hardcoded headers
        Request.Builder requestBuilder = new Request.Builder()
                .url(curl)
                .addHeader("X-Ipay-Auth-Code", "1")
                .addHeader("X-Ipay-Client-Id", Client_Id)
                .addHeader("X-Ipay-Client-Secret", Client_Secret)
                .addHeader("X-Ipay-Endpoint-Ip", endpointIp)
                .addHeader("Content-Type", "application/json");

        // Request body with parameters from user
        Map<String, String> requestBodyMap = new HashMap<>();
        requestBodyMap.put("transactionDate", dto.getTransactionDate());
        requestBodyMap.put("externalRef", dto.getExternalRef());
        requestBodyMap.put("source", "ORDER");

        // Convert request body map to JSON string
        String requestBodyJson = objectMapper.writeValueAsString(requestBodyMap);

        // Create Request Body
        RequestBody body = RequestBody.create(requestBodyJson, MediaType.get("application/json; charset=utf-8"));

        // Build the request
        Request request = requestBuilder.post(body).build();

        // Execute request and get response
        try (Response response = client.newCall(request).execute()) {  // Correct usage of OkHttpClient's newCall()
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Return response body as a string
            return response.body().string();
        }
    }

	
}
