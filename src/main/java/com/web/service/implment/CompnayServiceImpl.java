package com.web.service.implment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.CompanyDao;
import com.web.model.Company;
import com.web.service.CompnayService;
import com.web.service.Generic.GenericServiceImpl;

@Service
@Transactional
public class CompnayServiceImpl extends GenericServiceImpl<Company> implements CompnayService {

	@Autowired
	CompanyDao Dao;

}
