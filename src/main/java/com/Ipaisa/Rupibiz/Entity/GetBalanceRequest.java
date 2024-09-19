package com.Ipaisa.Rupibiz.Entity;

public class GetBalanceRequest {

	private String apiToken;

	public String getApiToken() {
		return apiToken;
	}

	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}

	@Override
	public String toString() {
		return "GetBalanceRequest [apiToken=" + apiToken + "]";
	}
	
	
}
