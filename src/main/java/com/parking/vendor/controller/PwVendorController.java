package com.parking.vendor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.vendor.model.PwVendor;
import com.parking.vendor.model.PwVendorAddress;
import com.parking.vendor.service.PwVendorService;

@RestController

@RequestMapping("/parkwisely/vendor")
public class PwVendorController {
	
	@Autowired
	PwVendorService vendorService;
	
    @RequestMapping(method = RequestMethod.POST, path = "/addVendor", produces = {
        MediaType.APPLICATION_JSON_VALUE
    }, consumes = {
        MediaType.APPLICATION_JSON_VALUE
    })

    public String addVendor( @RequestBody PwVendor vendor) {
        try {
        	PwVendorAddress add = new PwVendorAddress();
        	List<PwVendorAddress> address = new ArrayList<PwVendorAddress>();
        	add.setAddress1("fake");
        	add.setState("AP");
        	address.add(add);
        	vendor.setAddress(address);
        	vendorService.insertVendor(vendor);
        } catch (Exception e) {
        	e.printStackTrace();
            return "fail";
        }
        return "Inserted Successfully";

    }

}
