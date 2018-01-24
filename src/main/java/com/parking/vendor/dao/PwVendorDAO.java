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
	
	public boolean addAddress(PwVendorAddress address);
	
	public PwVendorAddress findAddress(int addressId);
	
	public boolean updateAddress(PwVendorAddress address);
	
	public boolean deleteVendor(int vendorId);
	
	public boolean deleteVendorAddress(int addressId);

}
