package com.parking.vendor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.vendor.model.PwVendor;
import com.parking.vendor.model.PwVendorAddress;
import com.parking.vendor.service.PwVendorService;

import io.swagger.annotations.ApiOperation;

@RestController

@RequestMapping("/parkwisely/vendor/api")
public class PwVendorController {

	@Autowired
	PwVendorService vendorService;
	
	
	@ApiOperation(value = "Getting the list of all vendors",response = List.class)
	@RequestMapping(method = RequestMethod.GET, path = "/vendorList", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public List<PwVendor> VendorHome() {
		return vendorService.getAllVendors();
	}

	
	@ApiOperation(value = "This api is used to register the vendor",response = String.class)
	@RequestMapping(method = RequestMethod.POST, path = "/registerVendor", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String registerVendor(@ModelAttribute PwVendor vendor) {
		vendorService.insertVendor(vendor);
		return "Vendor inserted successfully";
	}
	
	
	@ApiOperation(value = "Get the vendor a particular vendor Id",response = PwVendor.class)
	@RequestMapping(method = RequestMethod.GET, path = "/getVendor/{vendorId}", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public PwVendor  getVendor(@ModelAttribute PwVendor vendor,@PathVariable int vendorId) {
		return vendorService.findVendor(vendorId);
	}
	
	
	@ApiOperation(value = "Get the address a particular address Id",response = PwVendorAddress.class)
	@RequestMapping(method = RequestMethod.GET, path = "/getAddress/{addressId}", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public PwVendorAddress  getAddress(@ModelAttribute PwVendor vendor,@PathVariable int addressId) {
		return vendorService.getAddress(addressId);
	}

	
	@ApiOperation(value = "Update vendor details only",response = PwVendor.class)
	@RequestMapping(method = RequestMethod.POST, path = "/updateVendor", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public PwVendor updateVendor(@ModelAttribute PwVendor vendor) {
		PwVendor oldVendor = vendorService.findVendor(vendor.getVendorId());
		vendor.setAddress(oldVendor.getAddress());
		vendorService.updateVendor(vendor);
		return vendor;
	}

	@ApiOperation(value = "Adding a new address to vendor ",response = PwVendor.class)
	@RequestMapping(method = RequestMethod.POST, path = "/addAddress/{vendorId}", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public PwVendor addVendorAddress(@ModelAttribute PwVendorAddress address, int vendorId) {
		PwVendor vendor = vendorService.findVendor(vendorId);
		List<PwVendorAddress> addressList = vendor.getAddress();
		if (addressList == null) {
			addressList = new ArrayList<PwVendorAddress>();
		}
		addressList.add(address);
		vendor.setAddress(addressList);
		vendorService.insertAddress(address);
		vendorService.updateVendor(vendor);
		return vendor;
	}

	@ApiOperation(value = "Updating an address ",response = String.class)
	@RequestMapping(method = RequestMethod.POST, path = "/editAddress", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String editAddress(@ModelAttribute PwVendorAddress address, int vendorId) {
		vendorService.updateAddress(address);
		return "Address updated successfully";
	}

}
