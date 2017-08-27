package com.web.service;

import java.util.List;

import com.web.model.Company;

public interface CompnayService {

	public void AddCompany(Company com);

	public void UpdateCompany(Company com);

	public void DeleteCompany(int id);

	public List<Company> findAllCompany();

	public Company findbyOne(int id);
}