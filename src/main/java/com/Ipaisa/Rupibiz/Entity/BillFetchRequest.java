package com.Ipaisa.Rupibiz.Entity;

public class BillFetchRequest {
	private String apiToken;
	 private String mn;
	 private String op;
	 private String amt;
	 private String reqid;
	 private String field1;
	 private String field2;
	 private String field3;
	 private String field4;
	 private String field5;
	 private String field6;
	 private String field7;
	 private String field8;
	 private String field9;
	 private String field10;
	 private String custmn;
		 
	
	public BillFetchRequest(String apiToken, String mn, String op, String amt, String reqid) {
		super();
		this.apiToken = apiToken;
		this.mn = mn;
		this.op = op;
		this.amt = amt;
		this.reqid = reqid;
		
	}
	//getter & setter--
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
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public String getField3() {
		return field3;
	}
	public void setField3(String field3) {
		this.field3 = field3;
	}
	public String getField4() {
		return field4;
	}
	public void setField4(String field4) {
		this.field4 = field4;
	}
	public String getField5() {
		return field5;
	}
	public void setField5(String field5) {
		this.field5 = field5;
	}
	public String getField6() {
		return field6;
	}
	public void setField6(String field6) {
		this.field6 = field6;
	}
	public String getField7() {
		return field7;
	}
	public void setField7(String field7) {
		this.field7 = field7;
	}
	public String getField8() {
		return field8;
	}
	public void setField8(String field8) {
		this.field8 = field8;
	}
	public String getField9() {
		return field9;
	}
	public void setField9(String field9) {
		this.field9 = field9;
	}
	public String getField10() {
		return field10;
	}
	public void setField10(String field10) {
		this.field10 = field10;
	}
	public String getCustmn() {
		return custmn;
	}
	public void setCustmn(String custmn) {
		this.custmn = custmn;
	}
		@Override
	public String toString() {
		return "RechargeRequest [apiToken=" + apiToken + ", mn=" + mn + ", op=" + op + ", amt=" + amt + ", reqid=" + reqid
				+ ", field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + ", field4=" + field4 + ", field5="
				+ field5 + ", field6=" + field6 + ", field7=" + field7 + ", field8=" + field8 + ", field9=" + field9
				+ ", field10=" + field10 + ", custmn=" + custmn + "]";
	}
	 

}
