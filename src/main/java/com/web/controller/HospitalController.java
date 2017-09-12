package com.web.controller;

import org.apache.log4j.Logger;
import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.web.model.Hospital;
import com.web.service.HospitalService;

@Controller
@RequestMapping("/hospital")
@SessionAttributes("roles")
public class HospitalController {
	Logger Log = Logger.getLogger(HospitalController.class);

	@Autowired
	HospitalService service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listHospital(ModelMap model) {

		Log.info("---------listHospital--------" + service.findAllHospital().toString());
		model.addAttribute("hosptials", service.findAllHospital());
		return "/jsp/hospital/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addtHospital(ModelMap model) {
		model.addAttribute(new Hospital());

		Log.info("listHospital");
		return "/jsp/hospital/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addtHospital(Hospital hos) {

		Log.info("-----------add Hospital post-------------");
		service.AddHospital(hos);

		return "redirect:/hospital/list";
	}

	@RequestMapping(value = "/{hos_name}", method = RequestMethod.GET)
	public String showHospital(@PathVariable String hos_name, Model model) {

		Log.info("showHospital");
		// model.addAttribute();
		return "/jsp/hospital/show";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String updateHospital(@PathVariable int id, Model model) {
		// display list
		Log.info("showHospital");
		// model.addAttribute();

		return "/jsp/hospital/update";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String updateHospital(Hospital hos, Model model) {

		// find com from data base
		// update com set from web
		// model.addAttribute();
		return "redirect:/hospital/list";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteHospital(@PathVariable Long id, Model model) {

		Log.info("-------------------deleteHospital------------------");
		service.DeleteHospital(id);

		return "redirect:/hospital/list";
	}
}
