package com.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.web.model.Company;
import com.web.model.Medicine;
import com.web.service.CompnayService;
import com.web.service.MedicineService;

@Controller
@RequestMapping("/company")
@SessionAttributes("roles")
public class CompanyController {
	Logger Log = Logger.getLogger(CompanyController.class);

	@Autowired
	CompnayService compnayService;

	@Autowired
	MedicineService medService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listCompany(ModelAndView model) {

		model = new ModelAndView("/jsp/company/list");
		model.addObject("coms", compnayService.getAll());

		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCompany(Model model) {
		model.addAttribute(new Company());
		Log.info("addCompany GET");

		return "/jsp/company/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCompany(HttpServletRequest request, Company company) {

		Log.info(request.getCharacterEncoding());
		Log.info(request.getParameter("com_name"));
		compnayService.add(company);

		return "redirect:/company/list";
	}

	@RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
	public String showCompany(@PathVariable Long id, Model model) {

		List<Medicine> meds = medService.findAllByCompanyId(id);
		Company company = compnayService.findbyOne(id);

		model.addAttribute("com", company);
		model.addAttribute("meds", meds);

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
	public String deleteCompany(@PathVariable Long id, Model model) {

		Log.info("deleteCompany");
		compnayService.removebyId(id);
		;
		// model.addAttribute();
		return "redirect:/company/list";
	}
}
