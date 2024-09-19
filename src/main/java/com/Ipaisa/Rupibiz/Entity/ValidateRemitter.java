package com.Ipaisa.Rupibiz.Entity;

public class ValidateRemitter {

	private String mobile;
	private String remitterId;
	private String otp;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRemitterId() {
		return remitterId;
	}
	public void setRemitterId(String remitterId) {
		this.remitterId = remitterId;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	
	public ValidateRemitter() {
		
	}
	
	public ValidateRemitter(String mobile, String remitterId, String otp) {
		super();
		this.mobile = mobile;
		this.remitterId = remitterId;
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "ValidateRemitter [mobile=" + mobile + ", remitterId=" + remitterId + ", otp=" + otp + "]";
	}
	
}
