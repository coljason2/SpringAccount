package com.web.service.implment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.HospitalDao;
import com.web.model.Hospital;
import com.web.service.HospitalService;
import com.web.service.Generic.GenericServiceImpl;

@Service
@Transactional
public class HospitalServiceImpl extends GenericServiceImpl<Hospital> implements HospitalService {

	@Autowired
	HospitalDao dao;

}
