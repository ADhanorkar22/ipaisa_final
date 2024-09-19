package com.Ipaisa.Rupibiz.Entity;

public class TransferRequest {
	private String apiToken;
	private String mn;
	private String op;
	private String amt;
	private String reqid;
	private String beneficiary_id;
	private String imps;
	
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
	public String getBeneficiary_id() {
		return beneficiary_id;
	}
	public void setBeneficiary_id(String beneficiary_id) {
		this.beneficiary_id = beneficiary_id;
	}
	public String getImps() {
		return imps;
	}
	public void setImps(String imps) {
		this.imps = imps;
	}
	
	public TransferRequest() {}
	public TransferRequest(String apiToken, String mn, String op, String amt, String reqid, String beneficiary_id,
			String imps) {
		super();
		this.apiToken = apiToken;
		this.mn = mn;
		this.op = op;
		this.amt = amt;
		this.reqid = reqid;
		this.beneficiary_id = beneficiary_id;
		this.imps = imps;
	}
	@Override
	public String toString() {
		return "TransferRequest [apiToken=" + apiToken + ", mn=" + mn + ", op=" + op + ", amt=" + amt + ", reqid="
				+ reqid + ", beneficiary_id=" + beneficiary_id + ", imps=" + imps + "]";
	}
	
	
	
}
