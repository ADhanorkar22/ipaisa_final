package com.Ipaisa.Rupibiz.Service;

import okhttp3.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class DTHOperatorService {

	    private static final String API_URL = "http://operatorcheck.mplan.in/api/dthoperatorinfo.php?apikey=";

	    public DTHOperatorService getDthOperatorInfo(String apiKey, String offer, String tel) throws Exception {
	        OkHttpClient client = new OkHttpClient().newBuilder().build();

	        HttpUrl url = HttpUrl.parse(API_URL)
	                .newBuilder()
	                .addQueryParameter("apikey", apiKey)
	                .addQueryParameter("offer", offer)
	                .addQueryParameter("tel", tel)
	                .build();

	        Request request = new Request.Builder()
	                .url(url)
	                .method("GET", null)
	                .build();

	        try (Response response = client.newCall(request).execute()) {
	            if (!response.isSuccessful()) {
	                throw new Exception("Unexpected response code: " + response.code());
	            }

	            String jsonResponse = response.body().string();
	            ObjectMapper objectMapper = new ObjectMapper();
	            return objectMapper.readValue(jsonResponse, DTHOperatorService.class);
	        }
	    }
	}



