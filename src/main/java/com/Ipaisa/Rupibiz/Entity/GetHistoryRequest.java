package com.Ipaisa.Rupibiz.Entity;

public class GetHistoryRequest {

	private String apiToken;
	private String format;
	private String remitter_id;
	//getter & setter
	
	public String getApiToken() {
		return apiToken;
	}
	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getRemitter_id() {
		return remitter_id;
	}
	public void setRemitter_id(String remitter_id) {
		this.remitter_id = remitter_id;
	}
	@Override
	public String toString() {
		return "GetHistoryRequest [apiToken=" + apiToken + ", format=" + format + ", remitter_id=" + remitter_id + "]";
	}
	
	
}
