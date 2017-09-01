package com.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/medicine")
@SessionAttributes("roles")
public class MedicineController {
	Logger Log = Logger.getLogger(MedicineController.class);

	@RequestMapping(value = "list")
	public String listMedicine(ModelMap model) {

		Log.error("listMedicine");
		return "/jsp/medicine/list";
	}
}
