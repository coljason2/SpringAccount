package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.web.service.AccountFormService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	@Autowired
	MessageSource messageSource;
	@Autowired
	AccountFormService Accountservice;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(ModelMap model) {
		String[] companys = { "信輝", "永信", "中化" };
		model.addAttribute("companys", companys);

		// Accountservice.findAllAccountForm();
		return "/jsp/home";
	}

}
