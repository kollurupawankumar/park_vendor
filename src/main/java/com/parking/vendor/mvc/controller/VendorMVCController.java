package com.parking.vendor.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
			for (PwVendor ven : vendorService.getAllVendors()){
				System.out.println("Pawan :"+ ven.getAddress());
			}
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
	
	@RequestMapping(method = RequestMethod.POST, value="/update")
	public ModelAndView updateVendor(@ModelAttribute PwVendor vendor, @ModelAttribute List<PwVendorAddress> address){
		PwVendor oldVendor  = vendorService.findVendor(vendor.getVendorId());
		vendor.setAddress(oldVendor.getAddress());
		vendorService.updateVendor(vendor);
		return new ModelAndView("redirect:/parkwisely/mvc/vendor/home");
	}
	

	@RequestMapping(method = RequestMethod.GET, value="/addAddress")
	public ModelAndView addAddress(Model model, int vendorId){
		model.addAttribute("address", new PwVendorAddress());
		model.addAttribute("vendorId", vendorId);
		return new ModelAndView("add_address");
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/modifyAddress")
	public ModelAndView modifyAddress(Model model, int vendorId){
		System.out.println("Pawan vendor Id "+ vendorId);
		PwVendor vendor =  vendorService.findVendor(vendorId);
		List<PwVendorAddress> addressList = vendor.getAddress();
		System.out.println(addressList.size());
		model.addAttribute("addressList", addressList);
		model.addAttribute("vendorId", vendorId);
		return new ModelAndView("address");
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
		vendorService.insertAddress(address);
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
