package com.Ipaisa.Rupibiz.Service;


import okhttp3.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DTHCustomerInfoService {
	
	
	@Value("${rupeebiz.api.key}")
    private String apikey;

        private static final String BASE_URL = "https://www.mplan.in/api/Dthinfo.php";

	    public String getDthCustomerInfo(String offer ,String tel,String operator) throws Exception {
	    	 OkHttpClient client = new OkHttpClient().newBuilder()
	                 .build();

	         // Build the URL with query parameters
	         HttpUrl url = HttpUrl.parse(BASE_URL).newBuilder()
	                 .addQueryParameter("apikey",apikey)
	                 .addQueryParameter("offer", offer)
	                 .addQueryParameter("tel",tel )
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

