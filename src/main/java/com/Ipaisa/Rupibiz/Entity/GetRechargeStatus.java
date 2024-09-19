package com.Ipaisa.Rupibiz.Entity;

import java.time.LocalDate;

public class GetRechargeStatus {
	private String apiToken;
	private String reqid;
	private LocalDate txnDate;
	public String getApiToken() {
		return apiToken;
	}
	public void setApiToken(String apiToken) {
		this.apiToken = apiToken;
	}
	public String getReqid() {
		return reqid;
	}
	public void setReqid(String reqid) {
		this.reqid = reqid;
	}
	public LocalDate getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(LocalDate txnDate) {
		this.txnDate = txnDate;
	}
	@Override
	public String toString() {
		return "GetRechargeStatus [apiToken=" + apiToken + ", reqid=" + reqid + ", txnDate=" + txnDate + "]";
	}

	
	}

