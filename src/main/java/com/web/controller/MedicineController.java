package com.web.controller;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.apache.log4j.Logger;
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
		List<Medicine> meds = medService.getAll();

		Collections.sort(meds, new Medicine());
		model.addAttribute("meds", meds);

		return "/jsp/medicine/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addMedicine(Model model) {

		model.addAttribute("coms", comService.getAll());

		return "/jsp/medicine/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMedicine(@RequestParam String med_name, @RequestParam UUID company_id, Model model) {

		if (med_name == null || med_name.equals("")) {

			model.addAttribute("error", "藥品名稱不能為空白");
			model.addAttribute("coms", comService.getAll());

			return "/jsp/medicine/add";
		} else {

			Medicine med = new Medicine();
			med.setName(med_name);

			if (company_id == null)
				med.setCompany(new Company());
			else
				med.setCompany(comService.findbyOne(company_id));

			Log.info("-----------" + med.toString() + "------------------");

			medService.add(med);

			return "redirect:/medicine/list";
		}
	}

	@RequestMapping(value = "/{med_name}", method = RequestMethod.GET)
	public String showMedicine(@PathVariable String med_name, Model model) {

		Log.info("showHospital");

		return "/jsp/medicine/show";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String updateMedicine(@PathVariable UUID id, Model model) {

		model.addAttribute("med", medService.findbyOne(id));
		model.addAttribute("coms", comService.getAll());

		return "/jsp/medicine/edit";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String updateMedicine(Model model, @RequestParam UUID med_id, @RequestParam String med_name,
			@RequestParam UUID company_id, @RequestParam String now_company) {

		Medicine medicine = medService.findbyOne(med_id);
		medicine.setMed_name(med_name);
		Company company = comService.findbyOne(company_id);

		if (!company.getCom_name().equals(now_company)) {
			medicine.setCompany(company);
		} else {
			medicine.setCompany(medicine.getCompany());
		}

		medService.update(medicine);

		return "redirect:/medicine/list";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteMedicine(@PathVariable UUID id, Model model) {

		medService.removebyId(id);

		return "redirect:/medicine/list";
	}
}
