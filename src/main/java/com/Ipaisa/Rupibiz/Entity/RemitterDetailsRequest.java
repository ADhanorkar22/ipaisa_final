package com.Ipaisa.Rupibiz.Entity;

public class RemitterDetailsRequest {
private String apiToken;
private String format;
private String mobile;
private String outletid;
public String getOutletid() {
	return outletid;
}
public void setOutletid(String outletid) {
	this.outletid = outletid;
}
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
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
@Override
public String toString() {
	return "RemitterDetailsRequest [apiToken=" + apiToken + ", format=" + format + ", mobile=" + mobile + ",outletid="+ outletid +"]";
}


}
