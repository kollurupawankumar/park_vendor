package com.parking.vendor.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.parking.vendor.dao.PwVendorDAO;
import com.parking.vendor.model.PwVendor;
import com.parking.vendor.model.PwVendorAddress;

@Repository
public class PwVendorDAOImpl implements PwVendorDAO {

	@Autowired
	MongoOperations mongoOps;


	@Override
	public boolean insertVendor(PwVendor vendor) {
		try {
			vendor.setVendorId(getVendorCount() + 1);
			mongoOps.insert(vendor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateVendor(PwVendor vendor) {
		try {
			mongoOps.save(vendor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<PwVendor> getAllVendors() {
		return mongoOps.findAll(PwVendor.class);
	}

	@Override
	public List<PwVendorAddress> getAddressForVendor(int vendorId) {
		PwVendor vendor = mongoOps.findById(vendorId, PwVendor.class);
		return vendor.getAddress();
	}

	@Override
	public int getVendorCount() {
		if (getAllVendors() != null)
			return getAllVendors().size();
		else
			return 0;
	}

}
