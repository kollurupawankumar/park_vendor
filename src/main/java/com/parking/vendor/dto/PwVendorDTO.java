package com.parking.vendor.dto;

import java.util.Date;
import java.util.List;

import com.parking.vendor.model.PwVendorAddress;

public class PwVendorDTO {
	
	private Date efftDt;
	private String name;
	private String emailId;
	private String vendorType;
	private String password;
	private Boolean corporateInd = true;
	private List<PwVendorAddressDTO> address;
	public Date getEfftDt() {
		return efftDt;
	}
	public void setEfftDt(Date efftDt) {
		this.efftDt = efftDt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getVendorType() {
		return vendorType;
	}
	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getCorporateInd() {
		return corporateInd;
	}
	public void setCorporateInd(Boolean corporateInd) {
		this.corporateInd = corporateInd;
	}
	public List<PwVendorAddressDTO> getAddress() {
		return address;
	}
	public void setAddress(List<PwVendorAddressDTO> address) {
		this.address = address;
	}
	
	
	
	

}
