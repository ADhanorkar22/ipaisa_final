package com.Ipaisa.Rupibiz.Entity;

public class BeneficiaryRemoveValidateRequest {
	private String apiToken;
	private String format;
	private String beneficiary_id;
	private String remitter_id;
    private String otp;
    private String outletid;
	
    //getter and setter
    
    
    public String getApiToken() {
		return apiToken;
	}
	public String getOutletid() {
		return outletid;
	}
	public void setOutletid(String outletid) {
		this.outletid = outletid;
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
	public String getRemitter_id() {
		return remitter_id;
	}
	public void setRemitter_id(String remitter_id) {
		this.remitter_id = remitter_id;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public BeneficiaryRemoveValidateRequest() {
		
	}
	public BeneficiaryRemoveValidateRequest(String apiToken, String format, String beneficiary_id, String remitter_id,
			String otp, String outletid) {
		super();
		this.apiToken = apiToken;
		this.format = format;
		this.beneficiary_id = beneficiary_id;
		this.remitter_id = remitter_id;
		this.otp = otp;
		this.outletid = outletid;
	}
	@Override
	public String toString() {
		return "BeneficiaryRemoveValidateRequest [apiToken=" + apiToken + ", format=" + format + ", beneficiary_id="
				+ beneficiary_id + ", remitter_id=" + remitter_id + ", otp=" + otp + ", outletid=" + outletid + "]";
	}
	
	    
    
}
