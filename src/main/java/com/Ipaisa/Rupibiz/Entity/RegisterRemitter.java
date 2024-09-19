package com.Ipaisa.Rupibiz.Entity;

public class RegisterRemitter {

	private String mobile;
	private String name;
	private String surname;
	private String pincode;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public RegisterRemitter() {}
	public RegisterRemitter(String mobile, String name, String surname, String pincode) {
		super();
		this.mobile = mobile;
		this.name = name;
		this.surname = surname;
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "RegisterRemitter [mobile=" + mobile + ", name=" + name + ", surname=" + surname + ", pincode=" + pincode
				+ "]";
	}
	
	
}
