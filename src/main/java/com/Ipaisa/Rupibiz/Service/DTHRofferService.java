package com.Ipaisa.Rupibiz.Service;

import okhttp3.*;
import org.springframework.stereotype.Service;

@Service
public class DTHRofferService {
	
	    private static final String API_URL = "https://www.mplan.in/api/DthRoffer.php?apikey=[yourapikey]&offer=roffer&tel=";

	    public String getDthRoffer(String tel) throws Exception {
	        OkHttpClient client = new OkHttpClient().newBuilder()
	                .build();

	        MediaType mediaType = MediaType.parse("text/plain");
	        RequestBody body = RequestBody.create(mediaType, "");

	        Request request = new Request.Builder()
	                .url(API_URL + tel)
	                .method("GET", body)
	                .build();

	        try (Response response = client.newCall(request).execute()) {
	            if (!response.isSuccessful()) {
	                throw new Exception("Unexpected response code: " + response.code());
	            }

	            return response.body().string();
	        }
	    }
	}



