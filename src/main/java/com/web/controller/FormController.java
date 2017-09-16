package com.web.controller;

import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.model.AccountForm;
import com.web.service.AccountFormService;

@Controller
@RequestMapping("/form")
@SessionAttributes("roles")
public class FormController {
	Logger Log = Logger.getLogger(FormController.class);

	@Autowired
	AccountFormService Service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listForm(ModelMap model) {

		Log.info("FormController");

		model.addAttribute("forms", Service.getAll());
		return "/jsp/form/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(ModelMap model) {
		model.addAttribute(new AccountForm());
		Log.info("FormController");

		return "/jsp/form/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addForm(AccountForm accform) {

		Log.info("FormController");
		return "redirect:/jsp/form/list";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showForme(@PathVariable int id, Model model) {

		Log.info("showForm");
		// model.addAttribute();
		return "/jsp/form/show";
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
		Service.removebyId(id);;
		return "redirect:/jsp/form/list";
	}
}
