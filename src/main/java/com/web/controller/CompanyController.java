package com.web.controller;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

		return "/jsp/company/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCompany(@Valid Company company, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "/jsp/company/add";
		} else {
			compnayService.add(company);
			return "redirect:/company/list";

		}

	}

	@RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
	public String showCompany(@PathVariable UUID id, Model model) {

		List<Medicine> meds = medService.findAllByCompanyId(id);
		Company company = compnayService.findbyOne(id);

		model.addAttribute("com", company);
		model.addAttribute("meds", meds);

		return "/jsp/company/show";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String updateCompany(@PathVariable UUID id, Model model) {

		model.addAttribute("com", compnayService.findbyOne(id));

		return "/jsp/company/edit";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String updateCompany(@RequestParam UUID id, @RequestParam String com_name) {

		Company company = compnayService.findbyOne(id);
		company.setCom_name(com_name);
		compnayService.update(company);

		return "redirect:/company/list";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteCompany(@PathVariable UUID id, Model model) {

		medService.deleteMedByComId(id);
		compnayService.removebyId(id);

		return "redirect:/company/list";
	}

	@RequestMapping(value = "/{com_id}/{med_id}/delete", method = RequestMethod.GET)
	public String deleteMedicine(@PathVariable UUID com_id, @PathVariable UUID med_id, Model model) {

		medService.removebyId(med_id);

		return "redirect:/company/" + com_id + "/show";
	}

}
