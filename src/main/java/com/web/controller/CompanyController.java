package com.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listCompany(Model model) {

		Log.info("-------CompanyController--------" + compnayService.findAllCompany().toString());

		model.addAttribute("coms", compnayService.findAllCompany());

		return "/jsp/company/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCompany(Model model) {
		model.addAttribute(new Company());
		Log.info("addCompany GET");

		return "/jsp/company/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCompany(Company company) {
		Log.info("addCompany POST");
		Log.info("----------company--------------" + company.toString());
		compnayService.AddCompany(company);

		return "redirect:/company/list";
	}

	@RequestMapping(value = "/{com_name}", method = RequestMethod.GET)
	public String showCompany(@PathVariable String com_name, Model model) {

		Log.info("showCompany");
		// model.addAttribute();
		return "/jsp/company/show";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String updateCompany(@PathVariable int id, Model model) {

		Log.info("showCompany");
		// model.addAttribute();
		return "/jsp/company/update";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String updateCompany(Company com, Model model) {

		// find com from data base
		// update com set from web
		// model.addAttribute();
		return "redirect:/company/list";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteCompany(@PathVariable int id, Model model) {

		Log.info("deleteCompany");
		compnayService.DeleteCompany(id);
		// model.addAttribute();
		return "redirect:/company/list";
	}
}
