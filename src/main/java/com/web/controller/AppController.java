package com.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.web.model.AccountForm;
import com.web.model.Company;
import com.web.model.MedItem;
import com.web.model.Medicine;
import com.web.service.AccountFormService;
import com.web.service.CompnayService;
import com.web.service.MedItemService;
import com.web.service.MedicineService;
import com.web.vo.JSONmedItem;

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
	@Autowired
	AccountFormService Service;
	@Autowired
	MedItemService meditService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(ModelMap model) {
		return "redirect:/form/list";
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

	@RequestMapping(value = { "/VueAddMedItems" }, method = RequestMethod.POST, produces = "text/json;charset=UTF-8")
	@ResponseBody
	public String VueAddMedItems(@RequestBody String JSONobject) {
		JSONobject = "[" + JSONobject + "]";
		JSONArray array = JSON.parseArray(JSONobject);
		UUID formid = UUID.fromString(array.getJSONObject(0).get("formid").toString());
		String JSONItems = array.getJSONObject(0).get("JSONobject").toString();
		List<JSONmedItem> list = JSON.parseObject(JSONItems, new TypeReference<List<JSONmedItem>>() {
		});
		if (list.size() > 0) {
			int total = 0;
			AccountForm form = Accountservice.findbyOne(formid);
			for (JSONmedItem o : list) {
				MedItem item = new MedItem();
				item.setAccountForm(form);
				item.setMedicine(o.getName());
				item.setCompany(o.getCompany());
				item.setInputdate(o.getInputday());
				item.setInput_cost(o.getCost());
				item.setItemcount(o.getCount());
				item.setDiscount1(o.getDiscount1());
				item.setDiscount2(o.getDiscount2());
				item.setDiscount3(o.getDiscount3());
				item.setTotal(o.getTotal());
				meditService.add(item);
				total = total + o.getTotal();
			}
			form.setTotal(total);
			Accountservice.update(form);
			return "true";
		} else {
			return "false";
		}

	}

}
