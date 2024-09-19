package com.Ipaisa.Rupibiz.Entity;

public class RegisterComplaintRequest {

	private String apiToken;
	private String reqid;
	private String reason;
	
	//getter & setter-
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "RegisterComplaintRequest [apiToken=" + apiToken + ", reqid=" + reqid + ", reason=" + reason + "]";
	}
	
	
}
