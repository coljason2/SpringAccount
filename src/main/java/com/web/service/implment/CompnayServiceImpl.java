package com.web.service.implment;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.CompanyDao;
import com.web.model.Company;
import com.web.service.CompnayService;

@Service
@Transactional
public class CompnayServiceImpl implements CompnayService {
	final static Logger logger = Logger.getLogger(CompnayServiceImpl.class);

	@Autowired
	CompanyDao Dao;

	public void AddCompany(Company com) {
		Dao.AddEntity(com);

	}

	public void UpdateCompany(Company com) {
		logger.debug("Update one Company...");
		Company entity = Dao.findOne(com.getId());
		if (entity != null) {
			entity.setCom_name(com.getCom_name());
			entity.setUpdateDate(com.getUpdateDate());
			Dao.update(com);
		}

	}

	public void DeleteCompany(int id) {
		logger.debug("Delete one Company...");
		Dao.deleteById(id);
	}

	public List<Company> findAllCompany() {

		logger.debug("Getting all Companys...");
		return Dao.findAll();
	}

	public Company findbyOne(int id) {
		logger.debug("Getting one Company...");
		return Dao.findOne(id);
	}

}
