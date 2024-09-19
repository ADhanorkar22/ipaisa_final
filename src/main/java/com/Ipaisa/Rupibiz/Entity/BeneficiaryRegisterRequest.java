package com.Ipaisa.Rupibiz.Entity;

public class BeneficiaryRegisterRequest {

	private String apiToken;
	private String format;
	private String mobile;
	private String bankid;
	private String beneficiary_name;
	private String beneficiary_mobile;
	private String beneficiary_ifsc;
	private String beneficiary_account_no;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBankid() {
		return bankid;
	}
	public void setBankid(String bankid) {
		this.bankid = bankid;
	}
	public String getBeneficiary_name() {
		return beneficiary_name;
	}
	public void setBeneficiary_name(String beneficiary_name) {
		this.beneficiary_name = beneficiary_name;
	}
	public String getBeneficiary_mobile() {
		return beneficiary_mobile;
	}
	public void setBeneficiary_mobile(String beneficiary_mobile) {
		this.beneficiary_mobile = beneficiary_mobile;
	}
	public String getBeneficiary_ifsc() {
		return beneficiary_ifsc;
	}
	public void setBeneficiary_ifsc(String beneficiary_ifsc) {
		this.beneficiary_ifsc = beneficiary_ifsc;
	}
	public String getBeneficiary_account_no() {
		return beneficiary_account_no;
	}
	public void setBenficiary_account_no(String benficiary_account_no) {
		this.beneficiary_account_no = benficiary_account_no;
	}
	
	
	public String getOutletid() {
		return outletid;
	}
	public void setOutletid(String outletid) {
		this.outletid = outletid;
	}
	public void setBeneficiary_account_no(String beneficiary_account_no) {
		this.beneficiary_account_no = beneficiary_account_no;
	}
	
	public BeneficiaryRegisterRequest() {
		
	}
	
	public BeneficiaryRegisterRequest(String apiToken, String format, String mobile, String bankid,
			String beneficiary_name, String beneficiary_mobile, String beneficiary_ifsc, String beneficiary_account_no,
			String outletid) {
		super();
		this.apiToken = apiToken;
		this.format = format;
		this.mobile = mobile;
		this.bankid = bankid;
		this.beneficiary_name = beneficiary_name;
		this.beneficiary_mobile = beneficiary_mobile;
		this.beneficiary_ifsc = beneficiary_ifsc;
		this.beneficiary_account_no = beneficiary_account_no;
		this.outletid = outletid;
	}
	@Override
	public String toString() {
		return "BeneficiaryRegisterRequest [apiToken=" + apiToken + ", format=" + format + ", mobile=" + mobile
				+ ", bankid=" + bankid + ", beneficiary_name=" + beneficiary_name + ", beneficiary_mobile="
				+ beneficiary_mobile + ", beneficiary_ifsc=" + beneficiary_ifsc + ", beneficiary_account_no="
				+ beneficiary_account_no + ", outletid=" + outletid + "]";
	}
	
	
	
}	
