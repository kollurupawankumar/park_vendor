package com.parking.vendor.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



/**
 * 
 * @author kpawan
 *
 */

@Document
public class PwVendorAddress {
	
	@Id
	private int addId;
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
	private int noOf2W;
	private int costOf2W;
	private int noOf4W;
	private int costOf4W;
	private String entryMobile;
	private String exitMobile;
	
	
	
	
	
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
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
	public int getNoOf2W() {
		return noOf2W;
	}
	public void setNoOf2W(int noOf2W) {
		this.noOf2W = noOf2W;
	}
	public int getCostOf2W() {
		return costOf2W;
	}
	public void setCostOf2W(int costOf2W) {
		this.costOf2W = costOf2W;
	}
	public int getNoOf4W() {
		return noOf4W;
	}
	public void setNoOf4W(int noOf4W) {
		this.noOf4W = noOf4W;
	}
	public int getCostOf4W() {
		return costOf4W;
	}
	public void setCostOf4W(int costOf4W) {
		this.costOf4W = costOf4W;
	}
	public String getEntryMobile() {
		return entryMobile;
	}
	public void setEntryMobile(String entryMobile) {
		this.entryMobile = entryMobile;
	}
	public String getExitMobile() {
		return exitMobile;
	}
	public void setExitMobile(String exitMobile) {
		this.exitMobile = exitMobile;
	}
	@Override
	public String toString() {
		return "VendorAddress : [address1=" + address1 + ", address2=" + address2 + ", address3=" + address3
				+ ", country=" + country + ", state=" + state + ", city=" + city + ", pincode=" + pincode
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
	
	

}
