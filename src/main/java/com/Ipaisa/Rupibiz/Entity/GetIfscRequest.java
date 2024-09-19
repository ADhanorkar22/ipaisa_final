package com.Ipaisa.Rupibiz.Entity;

public class GetIfscRequest {
private String apiToken;
private String format;
private String bank_code;
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
public String getBank_code() {
	return bank_code;
}
public void setBank_code(String bank_code) {
	this.bank_code = bank_code;
}
@Override
public String toString() {
	return "GetIfscRequest [apiToken=" + apiToken + ", format=" + format + ", bank_code=" + bank_code + "]";
}

public GetIfscRequest() {}
public GetIfscRequest(String apiToken, String format, String bank_code) {
	super();
	this.apiToken = apiToken;
	this.format = format;
	this.bank_code = bank_code;
}


}
