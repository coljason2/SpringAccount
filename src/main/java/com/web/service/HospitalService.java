package com.web.service;

import java.util.List;

import com.web.model.Hospital;

public interface HospitalService {

	public void AddHospital(Hospital hos);

	public void UpdateHospital(Hospital hos);

	public void DeleteHospital(int id);

	public List<Hospital> findAllHospital();
}
