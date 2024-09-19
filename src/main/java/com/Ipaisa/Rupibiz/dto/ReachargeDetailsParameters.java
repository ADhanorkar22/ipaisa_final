package com.Ipaisa.Rupibiz.dto;

public class ReachargeDetailsParameters {

	 private String mn;
	 private String amt;
    private String providerName;
    
    
	public ReachargeDetailsParameters(String mn, String amt, String providerName) {
		super();
		this.mn = mn;
		this.amt = amt;
		this.providerName = providerName;
	}
	public ReachargeDetailsParameters() {
		super();
	}
	public String getMn() {
		return mn;
	}
	public void setMn(String mn) {
		this.mn = mn;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
    
    
}
