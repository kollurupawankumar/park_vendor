package com.parking.vendor.service.impl;

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
		
		boolean i =vendorDAO.insertVendor(vendor);
		System.out.println(vendor.getVendorId());
	}

}
