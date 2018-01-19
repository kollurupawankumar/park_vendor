package com.parking.vendor.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.parking.vendor.model.PwVendor;
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

}
