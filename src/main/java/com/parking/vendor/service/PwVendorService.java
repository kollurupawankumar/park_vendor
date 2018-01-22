package com.parking.vendor.service;

import java.util.List;

import com.parking.vendor.model.PwVendor;


public interface PwVendorService {
	
	public void insertVendor(PwVendor vendor);
	
	public List<PwVendor> getAllVendors();
	
	public PwVendor findVendor(int vendorId);
	
	public void updateVendor(PwVendor vendor);

}
