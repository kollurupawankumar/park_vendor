package com.parking.vendor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parking.vendor.model.PwVendor;


public interface PwVendorService {
	
	public void insertVendor(PwVendor vendor);
	
	public List<PwVendor> getAllVendors();

}
