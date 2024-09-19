package com.Ipaisa.Rupibiz.Service;

import org.springframework.stereotype.Service;
import okhttp3.*;


@Service
public class SimpleplanService {
	
	 private static final String BASE_URL = "https://www.mplan.in/api/plans.php";

	    public String fetchSimplePlanDetails(String circle, String operator) throws Exception {
	        OkHttpClient client = new OkHttpClient().newBuilder()
	                .build();

	        // Build the URL with query parameters
	        HttpUrl url = HttpUrl.parse(BASE_URL).newBuilder()
	                .addQueryParameter("apikey"," 7bcccd451342fae1ae498f91c20d6110")
	                .addQueryParameter("circle", circle)
	                .addQueryParameter("operator", operator)
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



