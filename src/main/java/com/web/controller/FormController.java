package com.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.model.AccountForm;

@Controller
@RequestMapping("/form")
@SessionAttributes("roles")
public class FormController {
	Logger Log = Logger.getLogger(FormController.class);

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listForm(ModelMap model) {

		Log.error("FormController");
		return "/jsp/form/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addForm(ModelMap model) {

		Log.error("FormController");
		return "/jsp/form/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addForm(AccountForm accform) {

		Log.error("FormController");
		return "/jsp/form/add";
	}
}
