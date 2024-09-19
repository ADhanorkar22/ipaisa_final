package com.Ipaisa.Rupibiz.Entity;

public class TransferStatusRequest {

	private String apiToken;
	private String format;
	private String reqid;
	private String txndate;
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
	public String getReqid() {
		return reqid;
	}
	public void setReqid(String reqid) {
		this.reqid = reqid;
	}
	public String getTxndate() {
		return txndate;
	}
	public void setTxndate(String txndate) {
		this.txndate = txndate;
	}
	
	public TransferStatusRequest() {
		
	}
	public TransferStatusRequest(String apiToken, String format, String reqid, String txndate) {
		super();
		this.apiToken = apiToken;
		this.format = format;
		this.reqid = reqid;
		this.txndate = txndate;
	}
	@Override
	public String toString() {
		return "TransferStatusRequest [apiToken=" + apiToken + ", format=" + format + ", reqid=" + reqid + ", txndate="
				+ txndate + "]";
	}
	
	
		
}
