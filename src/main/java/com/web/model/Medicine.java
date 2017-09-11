package com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.h2.command.dml.Update;

@Entity
@Table(name = "APP_MEDICINE")
public class Medicine implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2001463843075946122L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NAME", nullable = false)
	private String med_name;

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	@Column(name = "INP_DATE", nullable = false)
	private String IputDate;

	@Column(name = "UPADTE", nullable = false)
	private String Update;

	public String getMed_name() {
		return med_name;
	}

	public void setMed_name(String med_name) {
		this.med_name = med_name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return med_name;
	}

	public void setName(String name) {
		this.med_name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getIputDate() {
		return IputDate;
	}

	public void setIputDate(String iputDate) {
		IputDate = iputDate;
	}

	public String getUpdate() {
		return Update;
	}

	public void setUpdate(String update) {
		Update = update;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + med_name + ", company=" + company + "]";
	}

}
