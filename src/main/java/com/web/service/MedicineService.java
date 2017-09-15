package com.web.service;

import java.util.List;

import com.web.model.Medicine;
import com.web.service.Generic.GenericService;

public interface MedicineService extends GenericService<Medicine> {

	public List<Medicine> findAllByCompanyId(Long id);

	public void deleteMedByComId(Long id);
}
