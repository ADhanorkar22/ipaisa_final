package com.Ipaisa.utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class OkHttpClientSingleton {
	  private static OkHttpClient instance;

	    private OkHttpClientSingleton() {
	        // Private constructor to prevent instantiation
	    }

	    public static OkHttpClient getInstance() {
	        if (instance == null) {
	            synchronized (OkHttpClientSingleton.class) {
	                if (instance == null) {
	                    instance = new OkHttpClient.Builder()
	                        .connectTimeout(30000, TimeUnit.MILLISECONDS)
	                        .writeTimeout(30000, TimeUnit.MILLISECONDS)
	                        .readTimeout(30000, TimeUnit.MILLISECONDS)
	                        .build();
	                }
	            }
	        }
	        return instance;
	    }

}
