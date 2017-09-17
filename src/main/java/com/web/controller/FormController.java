package com.web.controller;

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

import com.web.model.AccountForm;
import com.web.service.AccountFormService;
import com.web.service.HospitalService;
import com.web.ulit.AccDateGenerate;
import com.web.ulit.OIDCreater;

@Controller
@RequestMapping("/form")
@SessionAttributes("roles")
public class FormController {
	Logger Log = Logger.getLogger(FormController.class);

	@Autowired
	AccountFormService Service;

	@Autowired
	HospitalService HosService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listForm(ModelMap model) {

		List<AccountForm> forms = Service.getAll();
		Log.info(forms.toString());
		model.addAttribute("forms", forms);
		return "/jsp/form/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(ModelMap model) {
		AccDateGenerate accday = new AccDateGenerate();

		model.addAttribute("hos", HosService.getAll());
		model.addAttribute("year", accday.getYear());
		model.addAttribute("month", accday.getDay());

		return "/jsp/form/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addForm(@RequestParam UUID hos_id, @RequestParam String acc_year, @RequestParam String acc_month) {

		AccountForm accountForm = new AccountForm();
		accountForm.setAcctDate(acc_year + "-" + acc_month);
		accountForm.setHospital(HosService.findbyOne(hos_id));
		accountForm.setOid(new OIDCreater().getOid());

		Service.add(accountForm);

		return "redirect:/form/list";
	}

	@RequestMapping(value = "/{id}/items", method = RequestMethod.GET)
	public String showItemsForm(@PathVariable UUID id, Model model) {

		model.addAttribute("form", Service.findbyOne(id));

		return "/jsp/form/items";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String updateForm(@PathVariable int id, Model model) {
		// display list
		Log.info("showForm");
		// model.addAttribute();

		return "/jsp/form/update";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String updateForm(AccountForm form, Model model) {

		// find com from data base
		// update com set from web
		// model.addAttribute();
		return "redirect:/jsp/form/list";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteForm(@PathVariable UUID id, Model model) {

		Log.info("deleteForm");
		Service.removebyId(id);
		;
		return "redirect:/form/list";
	}
}
