package com.web.model;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_MEDICINE")
@AttributeOverride(name = "id", column = @Column(name = "MEDITEM_ID", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class MedItem extends BaseMode {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6558213024133929663L;

	@Column(name = "COMPANY", nullable = false)
	private String company;

	@Column(name = "MED", nullable = false)
	private String medicine;

	@Column(name = "ITEM_COUNT", nullable = false)
	private Integer itemcount;

	@Column(name = "IN_COST")
	private String input_cost;

	@Column(name = "DIS_1")
	private String discount1;

	@Column(name = "DIS_2")
	private String discount2;

	@Column(name = "DIS_3")
	private String discount3;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FORM_ID", updatable = false, nullable = false)
	private AccountForm AccountForm;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getInput_cost() {
		return input_cost;
	}

	public void setInput_cost(String input_cost) {
		this.input_cost = input_cost;
	}

	public String getDiscount1() {
		return discount1;
	}

	public void setDiscount1(String discount1) {
		this.discount1 = discount1;
	}

	public String getDiscount2() {
		return discount2;
	}

	public void setDiscount2(String discount2) {
		this.discount2 = discount2;
	}

	public String getDiscount3() {
		return discount3;
	}

	public void setDiscount3(String discount3) {
		this.discount3 = discount3;
	}

	public AccountForm getAccountForm() {
		return AccountForm;
	}

	public void setAccountForm(AccountForm accountForm) {
		AccountForm = accountForm;
	}

	@Override
	public String toString() {
		return "MedItem [company=" + company + ", medicine=" + medicine + ", itemcount=" + itemcount + ", input_cost="
				+ input_cost + ", discount1=" + discount1 + ", discount2=" + discount2 + ", discount3=" + discount3
				+ ", AccountForm=" + AccountForm + ", id=" + id + "]";
	}
}
