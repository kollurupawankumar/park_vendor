package com.parking.vendor.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 
 * @author kpawan
 *
 */
@Document
public class PwVendor {

	@Id
	private int vendorId;
	
	private Date efftDt;
	private String name;
	private String emailId;
	private String vendorType;
	private String password;
	private Boolean corporateInd = true;
	private List<PwVendorAddress> address;
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	
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
	
	public List<PwVendorAddress> getAddress() {
		return address;
	}
	public void setAddress(List<PwVendorAddress> address) {
		this.address = address;
	}
	
	
	
	
	
}
