package com.Ipaisa.Rupibiz.Entity;

public class GetKycMandatoryRequest {
private String apiToken;
private String format;
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
public GetKycMandatoryRequest() {
	
}
public GetKycMandatoryRequest(String apiToken, String format) {
	super();
	this.apiToken = apiToken;
	this.format = format;
}
@Override
public String toString() {
	return "GetKycMandatoryRequest [apiToken=" + apiToken + ", format=" + format + "]";
}


}
