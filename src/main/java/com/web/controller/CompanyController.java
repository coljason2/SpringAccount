package com.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.service.CompnayService;

@Controller
@RequestMapping("/company")
@SessionAttributes("roles")
public class CompanyController {
	Logger Log = Logger.getLogger(CompanyController.class);

	@Autowired
	CompnayService compnayService;

	@RequestMapping(value = "list")
	public String listCompany(ModelMap model) {

		Log.error("CompanyController");
		return "/jsp/company/list";
	}
}
