package com.Ipaisa.Rupibiz.Entity;

public class InitiateRequest {
	private String apiToken;
	private String format;
	private String latlong;
	private String pancard;
	private String aadharnumber;
	private String email;
	private String mobile;

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

	public String getLatlong() {
		return latlong;
	}

	public void setLatlong(String latlong) {
		this.latlong = latlong;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getAadharnumber() {
		return aadharnumber;
	}

	public void setAadharnumber(String aadharnumber) {
		this.aadharnumber = aadharnumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public InitiateRequest() {

	}

	public InitiateRequest(String apiToken, String format, String latlong, String pancard, String aadharnumber,
			String email, String mobile) {
		super();
		this.apiToken = apiToken;
		this.format = format;
		this.latlong = latlong;
		this.pancard = pancard;
		this.aadharnumber = aadharnumber;
		this.email = email;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "InitiateRequest [apiToken=" + apiToken + ", format=" + format + ", latlong=" + latlong + ", pancard="
				+ pancard + ", aadharnumber=" + aadharnumber + ", email=" + email + ", mobile=" + mobile + "]";
	}

}
