package com.Ipaisa.Rupibiz.Entity;

public class GetRemitterrransferLimitRequest {
private String apiToken;
private String format;
private String mobile;
private String outletid;
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
public String getOutletid() {
	return outletid;
}
public void setOutletid(String outletid) {
	this.outletid = outletid;
}
@Override
public String toString() {
	return "GetRemitterrransferLimitRequest [apiToken=" + apiToken + ", format=" + format + ", mobile=" + mobile
			+ ", outletid=" + outletid + "]";
}

public GetRemitterrransferLimitRequest() {}

public GetRemitterrransferLimitRequest(String apiToken, String format, String mobile, String outletid) {
	super();
	this.apiToken = apiToken;
	this.format = format;
	this.mobile = mobile;
	this.outletid = outletid;
}


}
