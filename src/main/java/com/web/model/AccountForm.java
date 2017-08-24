package com.web.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APP_FORM")
public class AccountForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FORM_ID")
	private Integer id;
	@Column(name = "HOS_NAME", nullable = false)
	private String Hospital;
	@Column(name = "CRE_DATE", nullable = false)
	private String createDate;
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn(name = "FORM_ID")
	private List<MedItem> MedItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHospital() {
		return Hospital;
	}

	public void setHospital(String hospital) {
		Hospital = hospital;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public List<MedItem> getMedItems() {
		return MedItems;
	}

	public void setMedItems(List<MedItem> medItems) {
		MedItems = medItems;
	}

	@Override
	public String toString() {
		return "AccountForm [id=" + id + ", Hospital=" + Hospital + ", createDate=" + createDate + ", MedItems="
				+ MedItems + "]";
	}

}
