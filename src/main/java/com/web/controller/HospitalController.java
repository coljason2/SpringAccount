package com.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.model.Hospital;

@Controller
@RequestMapping("/hospital")
@SessionAttributes("roles")
public class HospitalController {
	Logger Log = Logger.getLogger(HospitalController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listHospital(ModelMap model) {
		Log.error("listHospital");
		return "/jsp/hospital/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addtHospital(ModelMap model) {
		Log.error("listHospital");
		return "/jsp/hospital/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addtHospital(Hospital hos) {

		Log.error("listHospital");
		return "/jsp/hospital/add";
	}
}
