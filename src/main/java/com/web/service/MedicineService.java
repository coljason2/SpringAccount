package com.web.service;

import java.util.List;

import com.web.model.Medicine;

public interface MedicineService {

	public void AddMedicine(Medicine med);

	public void UpdateMedicine(Medicine med);

	public void DeleteMedicine(Long id);

	public List<Medicine> findAllMedicine();
}
