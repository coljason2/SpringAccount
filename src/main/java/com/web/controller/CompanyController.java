package com.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.model.Company;
import com.web.service.CompnayService;

@Controller
@RequestMapping("/company")
@SessionAttributes("roles")
public class CompanyController {
	Logger Log = Logger.getLogger(CompanyController.class);

	@Autowired
	CompnayService compnayService;

	@Autowired
	Company Company;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listCompany(Model model) {

		Log.error("CompanyController");
		return "/jsp/company/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCompany(Model model) {
		model.addAttribute(new Company());
		Log.error("addCompany GET");

		return "/jsp/company/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCompany(Company company) {
		Log.error("addCompany POST");

		return "redirect:/jsp/company/list";
	}

	@RequestMapping(value = "/{com_name}", method = RequestMethod.GET)
	public String showCompany(@PathVariable String com_name, Model model) {

		Log.error("showCompany");
		// model.addAttribute();
		return "/jsp/company/show";
	}
}
