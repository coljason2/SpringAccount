package com.web.vo;

import java.util.List;
import com.google.common.collect.ImmutableList;
import com.web.model.Company;
import com.web.model.Hospital;

 public class GenerateFactory {

	private static final List<Hospital> Hospitals = new ImmutableList.Builder()
			.add(new Hospital("普門健康"))
			.add(new Hospital("普門醫院"))
			.add(new Hospital("普門診所"))
			.add(new Hospital("仁愛醫院")).build();

	private static final List<Company> Companys  = new ImmutableList.Builder()
			.add(new Company("生達"))
			.add(new Company("健亞"))
			.add(new Company("裕利"))
			.add(new Company("久裕"))
			.add(new Company("中化"))
			.add(new Company("信輝"))
			.add(new Company("大昌"))
			.add(new Company("信東")).build();

	public static List<Hospital> getHospitals() {
		return Hospitals;
	}

	public static List<Company> getCompanys() {
		return Companys;
	}
	
	
	
	
}
