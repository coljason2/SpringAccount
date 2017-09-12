package com.web.service;

import java.util.List;

import com.web.model.Hospital;

public interface HospitalService {

	public void AddHospital(Hospital hos);

	public void UpdateHospital(Hospital hos);

	public void DeleteHospital(Long id);

	public List<Hospital> findAllHospital();

	public Hospital findbyOne(Long id);
}
