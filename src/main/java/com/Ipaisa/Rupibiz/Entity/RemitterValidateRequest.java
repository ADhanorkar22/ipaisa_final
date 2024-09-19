package com.Ipaisa.Rupibiz.Entity;

public class RemitterValidateRequest {
	private String apiToken;
	private String format;
	private String mobile;
	//private String remitter_id;
	private String otpReference;
	private String otp;
	
	
	public String getOtpReference() {
		return otpReference;
	}
	public void setOtpReference(String otpReference) {
		this.otpReference = otpReference;
	}
	public void setOutletid(String outletid) {
		this.outletid = outletid;
	}
	private String outletid;
	
	public String getOutletid() {
		return outletid;
	}
	public void setOutledid(String outletid) {
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
//	public String getRemitter_id() {
//		return remitter_id;
//	}
//	public void setRemitter_id(String remitter_id) {
//		this.remitter_id = remitter_id;
//	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	public RemitterValidateRequest() {}
	
	public RemitterValidateRequest(String apiToken, String format, String mobile, String remitter_id, String otp, String outletid) {
		super();
		this.apiToken = apiToken;
		this.format = format;
		this.mobile = mobile;
		//this.remitter_id = remitter_id;
		this.otp = otp;
		this.outletid=outletid;
	}
	@Override
	public String toString() {
		return "RemitterValidateRequest [apiToken=" + apiToken + ", format=" + format + ", mobile=" + mobile
				+ ", otp=" + otp + ", outletid=" + outletid + "]";
	}
	
}


