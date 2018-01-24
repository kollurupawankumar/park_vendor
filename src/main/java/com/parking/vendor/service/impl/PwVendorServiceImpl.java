package com.parking.vendor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.vendor.dao.PwVendorDAO;
import com.parking.vendor.model.PwVendor;
import com.parking.vendor.model.PwVendorAddress;
import com.parking.vendor.service.PwVendorService;


@Service
public class PwVendorServiceImpl implements PwVendorService {

	@Autowired
	PwVendorDAO vendorDAO;
	
	@Override
	public void insertVendor(PwVendor vendor) {
		vendorDAO.insertVendor(vendor);
	}

	@Override
	public List<PwVendor> getAllVendors() {
		return vendorDAO.getAllVendors();
	}

	@Override
	public PwVendor findVendor(int vendorId) {
		return vendorDAO.findVendor(vendorId);
	}

	@Override
	public void updateVendor(PwVendor vendor) {
		vendorDAO.updateVendor(vendor);
		
	}

	@Override
	public boolean insertAddress(PwVendorAddress address) {
		vendorDAO.addAddress(address);
		return true;
	}

	@Override
	public PwVendorAddress getAddress(int addressId) {
		return vendorDAO.findAddress(addressId);
	}

	@Override
	public boolean updateAddress(PwVendorAddress address) {
		return vendorDAO.updateAddress(address);
	}

	@Override
	public boolean deleteVendor(int vendorId) {
		PwVendor vendor = vendorDAO.findVendor(vendorId);
		for (PwVendorAddress add : vendor.getAddress()){
			vendorDAO.deleteVendorAddress(add.getAddId());
		}
		vendorDAO.deleteVendor(vendorId);
		return true;
	}

	@Override
	public boolean deleteVendorAddress(int addressId) {
		return vendorDAO.deleteVendorAddress(addressId);
		
	}

	

}
