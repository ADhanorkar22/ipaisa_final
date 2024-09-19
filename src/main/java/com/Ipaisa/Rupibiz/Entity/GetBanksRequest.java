package com.Ipaisa.Rupibiz.Entity;

public class GetBanksRequest {
	private String apitoken;
	private String format;
	private String account;
	private String outletid;
	
	public String getOutletid() {
		return outletid;
	}
	public void setOutletid(String outletid) {
		this.outletid = outletid;
	}
	public String getApitoken() {
		return apitoken;
	}
	public void setApitoken(String apitoken) {
		this.apitoken = apitoken;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public GetBanksRequest() {
		
	}
		public GetBanksRequest(String apitoken, String format, String account, String outletid) {
		super();
		this.apitoken = apitoken;
		this.format = format;
		this.account = account;
		this.outletid = outletid;
	}
		
		@Override
		public String toString() {
			return "GetBanksRequest [apitoken=" + apitoken + ", format=" + format + ", account=" + account + ", outletid="
					+ outletid + "]";
		}

	

}


