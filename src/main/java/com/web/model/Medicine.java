package com.web.model;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "APP_MEDICINE")
@AttributeOverride(name = "id", column = @Column(name = "MEDICINE_ID", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class Medicine extends BaseMode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2001463843075946122L;

	@NotEmpty(message = "不能空白")
	@Column(name = "NAME", nullable = false)
	private String med_name;

	@ManyToOne
	@JoinColumn(name = "COMPANY_ID")
	private Company company;

	public String getMed_name() {
		return med_name;
	}

	public void setMed_name(String med_name) {
		this.med_name = med_name;
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

	@Override
	public String toString() {
		return "Medicine [med_name=" + med_name + ", company=" + company.getCom_name() + ", id=" + id + "]";
	}

}
