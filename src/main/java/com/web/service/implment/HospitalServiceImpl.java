package com.web.service.implment;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.HospitalDao;

import com.web.model.Hospital;
import com.web.service.HospitalService;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {
	final static Logger logger = Logger.getLogger(HospitalServiceImpl.class);

	@Autowired
	HospitalDao dao;

	public void AddHospital(Hospital hos) {
		dao.AddEntity(hos);
	}

	public void UpdateHospital(Hospital hos) {
		Hospital entity = dao.findOne(hos.getId());
		if (entity != null) {
			entity.setHos_name(hos.getHos_name());
			entity.setUpdateDate(hos.getUpdateDate());
		}

	}

	public void DeleteHospital(int id) {
		dao.deleteById(id);

	}

	public List<Hospital> findAllHospital() {
		return dao.findAll();
	}

}
