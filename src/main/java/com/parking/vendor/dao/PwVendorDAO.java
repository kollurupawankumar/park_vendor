package com.parking.vendor.dao;

import java.util.List;

import com.parking.vendor.model.PwVendor;
import com.parking.vendor.model.PwVendorAddress;



public interface PwVendorDAO {
	
	public boolean insertVendor(PwVendor vendor);
	
	public boolean updateVendor(PwVendor vendor);
	
	public List<PwVendor> getAllVendors();
	
	public List<PwVendorAddress> getAddressForVendor(int vendorId);
	
	public int getVendorCount();
	
	public PwVendor findVendor(int vendorId);

}
