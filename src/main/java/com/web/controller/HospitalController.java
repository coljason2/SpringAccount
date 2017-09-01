package com.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/hospital")
@SessionAttributes("roles")
public class HospitalController {
	Logger Log = Logger.getLogger(HospitalController.class);

	@RequestMapping(value = "list")
	public String listHospital(ModelMap model) {
		Log.error("listHospital");
		return "/jsp/hospital/list";
	}
}
