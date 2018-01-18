package com.parking.vendor.model;

import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;



/**
 * 
 * @author kpawan
 *
 */

public class PwVendorAddress {
	
	@Indexed
	private Date efftDt;
	private Boolean status;
	private String premiseType;
	private String address1;
	private String address2;
	private String address3;
	private String country;
	private String state;
	private String city;
	private String pincode;
	private String latitude;
	private String longitude;
	
	
	
	
	
	public Date getEfftDt() {
		return efftDt;
	}
	public void setEfftDt(Date efftDt) {
		this.efftDt = efftDt;
	}
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getPremiseType() {
		return premiseType;
	}
	public void setPremiseType(String premiseType) {
		this.premiseType = premiseType;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	
	

}
