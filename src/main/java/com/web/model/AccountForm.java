package com.web.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APP_FORM")
@AttributeOverride(name = "id", column = @Column(name = "FORM_ID", nullable = false))
public class AccountForm extends BaseMode {

	private static final long serialVersionUID = -7440178362536621969L;

	@ManyToOne
	@JoinColumn(name = "HOSPITAL_ID")
	private Hospital hospital;

	@Column(name = "FORM_TOTAL")
	private Integer total;

	// 記帳月份
	@Column(name = "ACC_DATE")
	private String acctDate;

	@OneToMany
	@JoinColumn(name = "FORM_ID")
	private List<MedItem> MedItems;

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public List<MedItem> getMedItems() {
		return MedItems;
	}

	public void setMedItems(List<MedItem> medItems) {
		MedItems = medItems;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "AccountForm [Hospital=" + hospital.getHos_name() + ", total=" + total + ", id=" + id + "]";
	}

	public String getAcctDate() {
		return acctDate;
	}

	public void setAcctDate(String acctDate) {
		this.acctDate = acctDate;
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
