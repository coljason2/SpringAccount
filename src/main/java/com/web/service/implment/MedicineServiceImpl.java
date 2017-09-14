package com.web.service.implment;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.MedicineDao;
import com.web.model.Medicine;
import com.web.service.MedicineService;
import com.web.service.Generic.GenericServiceImpl;

@Service
@Transactional
public class MedicineServiceImpl extends GenericServiceImpl<Medicine> implements MedicineService {

	@Autowired
	MedicineDao dao;

	public List<Medicine> findAllByCompanyId(Long id) {

		return dao.findAllByCompanyId(id);

	}

}
