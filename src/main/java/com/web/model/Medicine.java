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
@AttributeOverride(name = "id", column = @Column(name = "MEDICINE_ID", nullable = false))
public class Medicine extends BaseMode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2001463843075946122L;

	@Column(name = "NAME", nullable = false, unique = true)
	private String med_name;

	@Column(name = "NUMBER_ID", nullable = true, unique = true)
	private String med_no_id;
	
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

	public String getMed_no_id() {
		return med_no_id;
	}

	public void setMed_no_id(String med_no_id) {
		this.med_no_id = med_no_id;
	}

	@Override
	public String toString() {
		return "Medicine [med_name=" + med_name + ", company=" + company.getCom_name() + ", id=" + id + "]";
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		Medicine o1 = (Medicine) arg0;
		Medicine o2 = (Medicine) arg1;
		return o1.getCompany().getId().compareTo(o2.getCompany().getId());

	}

}
