package com.Ipaisa.Rupibiz.Entity;

public class BeneficiaryRemoveRequest {
private String apiToken;
private String format;
private String beneficiary_id;
//private String remitter_id;
private String mobile;
private String outletid;

//getter & setter



public String getApiToken() {
	return apiToken;
}
public String getOutletid() {
	return outletid;
}
public void setOutletid(String outletid) {
	this.outletid = outletid;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
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
public String getBeneficiary_id() {
	return beneficiary_id;
}
public void setBeneficiary_id(String beneficiary_id) {
	this.beneficiary_id = beneficiary_id;
}
//public String getRemitter_id() {
//	return remitter_id;
//}
//public void setRemitter_id(String remitter_id) {
//	this.remitter_id = remitter_id;
//}



public BeneficiaryRemoveRequest() {}
public BeneficiaryRemoveRequest(String apiToken, String format, String beneficiary_id, String mobile) {
	super();
	this.apiToken = apiToken;
	this.format = format;
	this.beneficiary_id = beneficiary_id;
	this.mobile = mobile;
	this.outletid=outletid;
}
@Override
public String toString() {
	return "BeneficiaryRemoveRequest [apiToken=" + apiToken + ", format=" + format + ", beneficiary_id="
			+ beneficiary_id + ", mobile=" + mobile + ", outletid=" + outletid + "]";
}



}
