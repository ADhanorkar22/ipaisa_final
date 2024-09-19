package com.Ipaisa.Rupibiz.Entity;

public class BeneficiaryRegisterValidateRequest {

	private String apiToken;
	private String format;
	//private String remitter_id;
	private String beneficiary_id;
	
	private String otp;
	private String outletid;
	private String bank_id;
	
	
	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	
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
//	public String getRemitter_id() {
//		return remitter_id;
//	}
//	public void setRemitter_id(String remitter_id) {
//		this.remitter_id = remitter_id;
//	}
	public String getBeneficiary_id() {
		return beneficiary_id;
	}
	public void setBeneficiary_id(String beneficiary_id) {
		this.beneficiary_id = beneficiary_id;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	
	public String getOutletid() {
		return outletid;
	}
	public void setOutletid(String outletid) {
		this.outletid = outletid;
	}
	
	public BeneficiaryRegisterValidateRequest() {
		
	}
	public BeneficiaryRegisterValidateRequest(String apiToken, String format, String remitter_id, String beneficiary_id,
			String otp, String outletid) {
		super();
		this.apiToken = apiToken;
		this.format = format;
	//	this.remitter_id = remitter_id;
		this.bank_id=bank_id;
		this.beneficiary_id = beneficiary_id;
		this.otp = otp;
		this.outletid = outletid;
	}
	@Override
	public String toString() {
		return "BeneficiaryRegisterValidateRequest [apiToken=" + apiToken + ", format=" + format + ", beneficiary_id="
				+ beneficiary_id + ", otp=" + otp + ", outletid=" + outletid + ", bank_id=" + bank_id + "]";
	}
			
	
	
}
