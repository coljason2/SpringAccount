package com.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.web.model.Medicine;
import com.web.service.AccountFormService;
import com.web.service.CompnayService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {
	Logger Log = Logger.getLogger(AppController.class);

	@Autowired
	MessageSource messageSource;
	@Autowired
	AccountFormService Accountservice;
	@Autowired
	CompnayService comService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(ModelMap model) {

		model.addAttribute("companys", comService.getAll());

		return "/jsp/home";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = { "/AjaxSelectCompany" }, method = RequestMethod.POST)
	@ResponseBody
	public List<String> AjaxSelectCompany(String companyId) {
		List<String> meds = new ArrayList<String>();
		String company = companyId;

		Log.warn("company is " + company);

		if (company.equals("信輝")) {
			meds.add("AAA");
			meds.add("BBB");
			meds.add("CCC");
		} else if (company.equals("永信")) {
			meds.add("111");
			meds.add("222");
			meds.add("333");
		} else {
			meds.add("eee");
			meds.add("rrr");
			meds.add("ttt");
		}

		return meds;
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
