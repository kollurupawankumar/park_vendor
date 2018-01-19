package com.parking.vendor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.vendor.dao.PwVendorDAO;
import com.parking.vendor.model.PwVendor;
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

}
