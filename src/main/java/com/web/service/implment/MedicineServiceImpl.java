package com.web.service.implment;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.MedicineDao;
import com.web.model.Medicine;
import com.web.service.MedicineService;

@Service
@Transactional
public class MedicineServiceImpl implements MedicineService {
	final static Logger logger = Logger.getLogger(MedicineServiceImpl.class);

	@Autowired
	MedicineDao dao;

	@Override
	public void AddMedicine(Medicine com) {
		// TODO Auto-generated method stub

	}

	@Override
	public void UpdateMedicine(Medicine com) {
		// TODO Auto-generated method stub

	}

	@Override
	public void DeleteMedicine(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Medicine> findAllMedicine() {
		// TODO Auto-generated method stub
		return null;
	}

}
