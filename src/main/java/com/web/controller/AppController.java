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

import com.web.model.Company;
import com.web.model.Medicine;
import com.web.service.AccountFormService;
import com.web.service.CompnayService;
import com.web.service.MedicineService;

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
	@Autowired
	MedicineService medService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(ModelMap model) {

		List<Company> companies = comService.getAll();
		List<Medicine> medicines = medService.findAllByCompanyId(companies.get(0).getId());
		model.addAttribute("companys", companies);
		if (medicines != null)
			model.addAttribute("meds", medicines);
		else
			model.addAttribute("meds", "無藥品");

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
	public List<String> AjaxSelectCompany(String comName) {

		Log.info("comName = {} " + comName);
		List<Medicine> meds = medService.findAllByCompanyName(comName);
		List<String> name = new ArrayList<String>();
		if (meds != null)
			for (Medicine s : meds)
				name.add(s.getMed_name());

		if (name.size() != 0) {
			return name;
		} else {
			name.add("無藥品");
			return name;
		}

	}

}
