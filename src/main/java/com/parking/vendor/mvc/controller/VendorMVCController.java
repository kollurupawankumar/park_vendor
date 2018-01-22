package com.parking.vendor.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.parking.vendor.model.PwVendor;
import com.parking.vendor.model.PwVendorAddress;
import com.parking.vendor.service.PwVendorService;

@Controller
@RequestMapping(path = "parkwisely/mvc/vendor")
public class VendorMVCController {
	
	
	@Autowired
	PwVendorService vendorService;
	
	@RequestMapping("/home")
	public ModelAndView VendorHome(Model model) {
		try {
			model.addAttribute("vendors", vendorService.getAllVendors());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("home");
	}
	
	@RequestMapping("/add")
	public ModelAndView addVendor(Model model){
		PwVendor vendor = new PwVendor();
		model.addAttribute("vendor", vendor);
		return new ModelAndView("add_vendor");
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="/add")
	public ModelAndView registerVendor(@ModelAttribute PwVendor vendor){
		vendorService.insertVendor(vendor);
		return new ModelAndView("redirect:/parkwisely/mvc/vendor/home");
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addAddress")
	public ModelAndView addVendorAddress(@ModelAttribute PwVendorAddress address, int vendorId){
		PwVendor vendor =  vendorService.findVendor(vendorId);
		List<PwVendorAddress> addressList = vendor.getAddress();
		if (addressList == null){
			addressList = new ArrayList<PwVendorAddress>();
		}
		addressList.add(address);
		vendor.setAddress(addressList);
		vendorService.updateVendor(vendor);
		return new ModelAndView("redirect:/parkwisely/mvc/vendor/edit?vendorId="+vendorId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/edit")
	public ModelAndView editVendor(Model model, int vendorId){
		PwVendor vendor =  vendorService.findVendor(vendorId);
		model.addAttribute("vendor", vendor);
		model.addAttribute("vendorAdd", new PwVendorAddress());
		return new ModelAndView("edit_vendor");
	}

}
