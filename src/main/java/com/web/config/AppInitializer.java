package com.web.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.web.dao.CompanyDao;
import com.web.dao.HospitalDao;
import com.web.dao.MedicineDao;
import com.web.model.Company;
import com.web.model.Hospital;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Autowired
	private CompanyDao companyDao;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private MedicineDao medicineDao;

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {

		// CharacterEncodingFilter characterEncodingFilter = new
		// CharacterEncodingFilter();
		// characterEncodingFilter.setEncoding("UTF-8");
		// return new Filter[] { characterEncodingFilter, new SiteMeshFilter(),
		// };

		// filter change to spring security

		return null;

	}

}
