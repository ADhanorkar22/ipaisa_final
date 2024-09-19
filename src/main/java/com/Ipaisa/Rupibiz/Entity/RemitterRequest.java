package com.Ipaisa.Rupibiz.Entity;

public class RemitterRequest {
private String apiToken;
private String format;
private String mobile;
private String name;
private String surname;
private String pincode;
private String outletid;
private String addressline1;
private String addressline2;
private String area;
private String city;
private String district;
private String state;
private String country;
private String dob;

public String getOutletid() {
	return outletid;
}
public void setOutledid(String outletid) {
	this.outletid = outletid;
}
public String getAddressline1() {
	return addressline1;
}
public void setAddressline1(String addressline1) {
	this.addressline1 = addressline1;
}
public String getAddressline2() {
	return addressline2;
}
public void setAddressline2(String addressline2) {
	this.addressline2 = addressline2;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
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


public RemitterRequest() {}
@Override
public String toString() {
	return "RemitterRequest [apiToken=" + apiToken + ", format=" + format + ", mobile=" + mobile + ", name=" + name
			+ ", surname=" + surname + ", pincode=" + pincode + ", outletid=" + outletid + ", addressline1="
			+ addressline1 + ", addressline2=" + addressline2 + ", area=" + area + ", city=" + city + ", district="
			+ district + ", state=" + state + ", country=" + country + ", dob=" + dob + "]";
}
public RemitterRequest(String apiToken, String format, String mobile, String name, String surname, String pincode,
		String outletid, String addressline1, String addressline2, String area, String city, String district,
		String state, String country, String dob) {
	super();
	this.apiToken = apiToken;
	this.format = format;
	this.mobile = mobile;
	this.name = name;
	this.surname = surname;
	this.pincode = pincode;
	this.outletid = outletid;
	this.addressline1 = addressline1;
	this.addressline2 = addressline2;
	this.area = area;
	this.city = city;
	this.district = district;
	this.state = state;
	this.country = country;
	this.dob = dob;
}


}
