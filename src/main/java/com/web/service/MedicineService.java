package com.web.service;

import java.util.List;
import java.util.UUID;

import com.web.model.Medicine;
import com.web.service.Generic.GenericService;

public interface MedicineService extends GenericService<Medicine> {

	public List<Medicine> findAllByCompanyId(UUID id);

	public List<Medicine> findAllByCompanyName(String name);

	public void deleteMedByComId(UUID id);
}
