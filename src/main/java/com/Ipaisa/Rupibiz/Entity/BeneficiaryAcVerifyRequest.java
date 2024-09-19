package com.Ipaisa.Rupibiz.Entity;

public class BeneficiaryAcVerifyRequest
{

	private String apiToken;
	private String mn;
	private String op;
	private String amt;
	private String reqid;
	private String bankAccNo;
	private String ifscCode;
	
	//getter & setter
	
	public String getApiToken() {
		return apiToken;
	}
	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}
	public String getMn() {
		return mn;
	}
	public void setMn(String mn) {
		this.mn = mn;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getReqid() {
		return reqid;
	}
	public void setReqid(String reqid) {
		this.reqid = reqid;
	}
	public String getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(String bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	@Override
	public String toString() {
		return "BeneficiaryAcVerifyRequest [apiToken=" + apiToken + ", mn=" + mn + ", op=" + op + ", amt=" + amt
				+ ", reqid=" + reqid + ", bankAccNo=" + bankAccNo + ", ifscCode=" + ifscCode + "]";
	}
	
	
	
	
}
