package com.Ipaisa.Rupibiz.Service;



import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DTHOperatorCheckService {
	
	
	 @Value("${rupeebiz.api.key}")
	    private String apikey;

	    private static final String API_URL = "http://operatorcheck.mplan.in/api/dthoperatorinfo.php";

	    public String getDthOperatorInfo( String tel) throws Exception {
	        OkHttpClient client = new OkHttpClient().newBuilder().build();

	        // Build the URL with query parameters
	        HttpUrl url = HttpUrl.parse(API_URL).newBuilder()
	                .addQueryParameter("apikey",apikey)
	               .addQueryParameter("tel", tel)
	                .build();

	        Request request = new Request.Builder()
	                .url(url)
	                .get() // Use GET method
	                .build();

	        try (Response response = client.newCall(request).execute()) {
	            if (!response.isSuccessful()) throw new Exception("Unexpected code " + response);

	            return response.body().string();
	        }
	    }
	}
