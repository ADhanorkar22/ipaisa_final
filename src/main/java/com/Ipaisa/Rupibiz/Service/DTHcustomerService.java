package com.Ipaisa.Rupibiz.Service;
import okhttp3.*;
import org.springframework.stereotype.Service;

@Service
public class DTHcustomerService {
	


	    private static final String API_URL = "https://www.mplan.in/api/Dthinfo.php?apikey=00b76ff0039347c08bafc085e5ebcd9c&offer=roffer&tel=";

	    public String getDthInfo(String dth) throws Exception {
	        OkHttpClient client = new OkHttpClient().newBuilder()
	                .build();

	        MediaType mediaType = MediaType.parse("text/plain");
	        RequestBody body = RequestBody.create(mediaType, "");

	        Request request = new Request.Builder()
	                .url(API_URL + dth)
	                .method("GET", body)
	                .build();

	        try (Response response = client.newCall(request).execute()) {
	            if (!response.isSuccessful()) throw new Exception("Unexpected code " + response);

	            return response.body().string();
	        }
	    }
	}



