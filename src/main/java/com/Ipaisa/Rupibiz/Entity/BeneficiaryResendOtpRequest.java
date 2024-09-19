package com.Ipaisa.Rupibiz.Entity;

public class BeneficiaryResendOtpRequest {
private String apiToken;
private String format;
private String remitter_id;
private String benficiary_id;
private String outletid;

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
public String getBenficiary_id() {
	return benficiary_id;
}
public void setBenficiary_id(String benficiary_id) {
	this.benficiary_id = benficiary_id;
}

public String getOutletid() {
	return outletid;
}
public void setOutletid(String outletid) {
	this.outletid = outletid;
}

public BeneficiaryResendOtpRequest() {
	
}
public BeneficiaryResendOtpRequest(String apiToken, String format, String remitter_id, String benficiary_id,
		String outletid) {
	super();
	this.apiToken = apiToken;
	this.format = format;
	this.remitter_id = remitter_id;
	this.benficiary_id = benficiary_id;
	this.outletid = outletid;
}
@Override
public String toString() {
	return "BeneficiaryResendOtpRequest [apiToken=" + apiToken + ", format=" + format + ", remitter_id=" + remitter_id
			+ ", benficiary_id=" + benficiary_id + ", outletid=" + outletid + "]";
}


}
