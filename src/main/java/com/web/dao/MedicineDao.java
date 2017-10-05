package com.web.dao;

import java.util.List;
import java.util.UUID;

import com.web.dao.Generic.GenericDao;
import com.web.model.Medicine;

public interface MedicineDao extends GenericDao<Medicine> {

	public List<Medicine> findAllByCompanyId(UUID id);

	public void deleteByComId(UUID id);

	public List<Medicine> findAllByCompanyName(String name);
}
