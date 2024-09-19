package com.Ipaisa.Rupibiz.Entity;

public class KycValidateRequest {
private String apiToken;
private String format;
private String otp;
private String otpReferenceID;
private String hash;
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
public String getOtp() {
	return otp;
}
public void setOtp(String otp) {
	this.otp = otp;
}
public String getOtpReferenceID() {
	return otpReferenceID;
}
public void setOtpReferenceID(String otpReferenceID) {
	this.otpReferenceID = otpReferenceID;
}
public String getHash() {
	return hash;
}
public void setHash(String hash) {
	this.hash = hash;
}
public KycValidateRequest() {
	
}
public KycValidateRequest(String apiToken, String format, String otp, String otpReferenceID, String hash) {
	super();
	this.apiToken = apiToken;
	this.format = format;
	this.otp = otp;
	this.otpReferenceID = otpReferenceID;
	this.hash = hash;
}
@Override
public String toString() {
	return "KycValidateRequest [apiToken=" + apiToken + ", format=" + format + ", otp=" + otp + ", otpReferenceID="
			+ otpReferenceID + ", hash=" + hash + "]";
}



}
