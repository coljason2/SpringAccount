package com.web.dao;

import java.util.List;

import com.web.dao.Generic.GenericDao;
import com.web.model.Medicine;

public interface MedicineDao extends GenericDao<Medicine> {

	public List<Medicine> findAllByCompanyId(Long id);

	public void deleteByComId(Long id);
}
