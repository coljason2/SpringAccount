package com.web.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.web.model.Hospital;
import com.web.service.AccountFormService;
import com.web.service.HospitalService;

@Controller
@RequestMapping("/hospital")
@SessionAttributes("roles")
public class HospitalController {
	Logger Log = Logger.getLogger(HospitalController.class);

	@Autowired
	HospitalService service;

	@Autowired
	AccountFormService AccService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listHospital(ModelMap model) {

		model.addAttribute("hosptials", service.getAll());
		return "/jsp/hospital/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addtHospital(ModelMap model) {

		model.addAttribute(new Hospital());

		return "/jsp/hospital/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addtHospital(@Valid Hospital hos, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {

			return "/jsp/hospital/add";
		} else {
			service.add(hos);

			return "redirect:/hospital/list";
		}

	}

	@RequestMapping(value = "/{hos_id}/forms", method = RequestMethod.GET)
	public String showFormsHospital(@PathVariable UUID hos_id, Model model) {
		Log.info("----------hos_id = " + hos_id);
		model.addAttribute("hos", service.findbyOne(hos_id));
		model.addAttribute("forms", AccService.findByHosId(hos_id));

		return "/jsp/hospital/forms";
	}

	@RequestMapping(value = "/{hos_id}/update", method = RequestMethod.GET)
	public String updateHospital(@PathVariable UUID hos_id, Model model) {

		model.addAttribute("hos", service.findbyOne(hos_id));

		return "/jsp/hospital/edit";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String updateHospital(@RequestParam UUID hos_id, @RequestParam String hos_name) {

		Hospital hospital = service.findbyOne(hos_id);
		hospital.setHos_name(hos_name);
		service.update(hospital);

		return "redirect:/hospital/list";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteHospital(@PathVariable UUID id, Model model) {

		Log.info("-------------------deleteHospital------------------");
		service.removebyId(id);
		;

		return "redirect:/hospital/list";
	}
}
