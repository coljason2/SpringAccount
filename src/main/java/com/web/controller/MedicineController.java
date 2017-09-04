package com.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.model.Hospital;
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

	@RequestMapping(value = "/{med_name}", method = RequestMethod.GET)
	public String showMedicine(@PathVariable String med_name, Model model) {

		Log.error("showHospital");
		// model.addAttribute();
		return "/jsp/medicine/show";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String updateMedicine(@PathVariable int id, Model model) {
		// display list
		Log.error("showMedicine");
		// model.addAttribute();

		return "/jsp/medicine/update";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String updateMedicine(Medicine med, Model model) {

		// find com from data base
		// update com set from web
		// model.addAttribute();
		return "redirect:/jsp/medicine/list";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteMedicine(@PathVariable int id, Model model) {

		Log.error("deleteMedicine");
		// model.addAttribute();
		return "redirect:/jsp/medicine/list";
	}
}
