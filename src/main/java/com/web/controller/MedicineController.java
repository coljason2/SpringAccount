package com.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.h2.util.New;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.model.Company;
import com.web.model.Medicine;
import com.web.service.CompnayService;
import com.web.service.MedicineService;

@Controller
@RequestMapping("/medicine")
@SessionAttributes("roles")
public class MedicineController {
	Logger Log = Logger.getLogger(MedicineController.class);

	@Autowired
	MedicineService medService;

	@Autowired
	CompnayService comService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listMedicine(ModelMap model) {

		model.addAttribute("meds", medService.getAll());

		return "/jsp/medicine/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addMedicine(ModelMap model) {

		model.addAttribute("coms", comService.getAll());

		return "/jsp/medicine/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMedicine(@RequestParam String med_name, @RequestParam Long company_id) {

		Medicine med = new Medicine();
		med.setName(med_name);
		med.setCompany(comService.findbyOne(company_id));

		medService.add(med);

		return "/jsp/medicine/list";
	}

	@RequestMapping(value = "/{med_name}", method = RequestMethod.GET)
	public String showMedicine(@PathVariable String med_name, Model model) {

		Log.info("showHospital");

		return "/jsp/medicine/show";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String updateMedicine(@PathVariable int id, Model model) {

		Log.info("showMedicine");

		return "/jsp/medicine/update";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String updateMedicine(Medicine med, Model model) {

		return "redirect:/jsp/medicine/list";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteMedicine(@PathVariable Long id, Model model) {

		medService.removebyId(id);
		return "redirect:/jsp/medicine/list";
	}
}
