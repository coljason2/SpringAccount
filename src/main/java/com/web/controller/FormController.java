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
import org.springframework.web.servlet.ModelAndView;

import com.web.model.AccountForm;
import com.web.model.Company;
import com.web.model.MedItem;
import com.web.model.Medicine;
import com.web.service.AccountFormService;
import com.web.service.CompnayService;
import com.web.service.HospitalService;
import com.web.service.MedItemService;
import com.web.service.MedicineService;
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
	MedicineService medService;
	@Autowired
	HospitalService HosService;
	@Autowired
	MedItemService meditService;
	@Autowired
	CompnayService compnayService;

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
		model.addAttribute("companys", compnayService.getAll());
		model.addAttribute("meds", meditService.findbyformId(id));
		return "/jsp/form/items";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String updateForm(@PathVariable UUID id, Model model) {

		SetCompany(model);
		model.addAttribute("form", Service.findbyOne(id));

		return "/jsp/form/edit";
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

		meditService.removebyformId(id);
		Service.removebyId(id);
		return "redirect:/form/list";

	}

	@RequestMapping(value = "{fromid}/{medid}/delete", method = RequestMethod.GET)
	public String deleteMedItem(@PathVariable UUID fromid, @PathVariable UUID medid, Model model) {

		meditService.removebyId(medid);
		return "redirect:/form/" + fromid + "/items";

	}

	@RequestMapping(value = "{fromid}/{medid}/update", method = RequestMethod.GET)
	public String ShowUpdateMedItem(@PathVariable UUID fromid, @PathVariable UUID medid, Model model) {

		SetCompany(model);
		MedItem item = meditService.findbyOne(medid);

		model.addAttribute("item", item);

		return "/jsp/form/update";
	}

	@RequestMapping(value = "/{id}/exportpdf", method = RequestMethod.GET)
	public String exportpdf(@PathVariable UUID id, Model model) {

		model.addAttribute("form", Service.findbyOne(id));
		model.addAttribute("companys", compnayService.getAll());
		model.addAttribute("meds", meditService.findbyformId(id));

		return "/jsp/export/PDFexport";
	}

	@RequestMapping(value = "/{id}/exportexcel", method = RequestMethod.GET)
	public String exportexcel(@PathVariable UUID id, Model model) {

		model.addAttribute("form", Service.findbyOne(id));
		model.addAttribute("companys", compnayService.getAll());
		model.addAttribute("meds", meditService.findbyformId(id));

		return "/jsp/export/EXCELexport";
	}

	@RequestMapping(value = "/{id}/downloadPDF", method = RequestMethod.GET)
	public ModelAndView downloadExcel(@PathVariable UUID id) {
		System.out.println("---------------------downloadExcel------------------");
		// create some sample data
		// List<Book> listBooks = new ArrayList<Book>();
		// listBooks.add(new Book("Spring in Action", "Craig Walls",
		// "1935182358",
		// "June 29th 2011", 31.98F));
		// listBooks.add(new Book("Spring in Practice", "Willie Wheeler, Joshua
		// White",
		// "1935182056", "May 16th 2013", 31.95F));
		// listBooks.add(new Book("Pro Spring 3",
		// "Clarence Ho, Rob Harrop", "1430241071", "April 18th 2012", 31.85F));
		// listBooks.add(new Book("Spring Integration in Action", "Mark Fisher",
		// "1935182439",
		// "September 26th 2012", 28.73F));

		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("pdfView", "listBooks", "");
	}

	public void SetCompany(Model model) {
		List<Company> companies = compnayService.getAll();
		if (companies.size() > 0) {
			model.addAttribute("companys", companies);
			List<Medicine> medicines = medService.findAllByCompanyId(companies.get(0).getId());
			if (medicines != null)
				model.addAttribute("meds", medicines);
			else
				model.addAttribute("meds", "無藥品");
		} else {
			model.addAttribute("companys", "無藥廠");
			model.addAttribute("meds", "無藥品");
		}
	}
}
