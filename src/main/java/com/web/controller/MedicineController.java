package com.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.model.Medicine;

@Controller
@RequestMapping("/medicine")
@SessionAttributes("roles")
public class MedicineController {
	Logger Log = Logger.getLogger(MedicineController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listMedicine(ModelMap model) {

		Log.error("listMedicine");
		return "/jsp/medicine/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addMedicine(ModelMap model) {

		Log.error("listMedicine");
		return "/jsp/medicine/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMedicine(Medicine Medicine) {

		Log.error("listMedicine");
		return "/jsp/medicine/add";
	}
}
