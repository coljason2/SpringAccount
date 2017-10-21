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
@AttributeOverride(name = "id", column = @Column(name = "MEDITEM_ID", nullable = false))
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
	private int input_cost;

	@Column(name = "DIS_1")
	private int discount1;

	@Column(name = "DIS_2")
	private int discount2;

	@Column(name = "DIS_3")
	private int discount3;

	@Column(name = "INPUTDATE")
	private String inputdate;

	@ManyToOne
	@JoinColumn(name = "FORM_ID", updatable = false, nullable = false)
	private AccountForm accountform;

	@Column(name = "TOTAL")
	private int total;

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

	public int getInput_cost() {
		return input_cost;
	}

	public void setInput_cost(int input_cost) {
		this.input_cost = input_cost;
	}

	public int getDiscount1() {
		return discount1;
	}

	public void setDiscount1(int discount1) {
		this.discount1 = discount1;
	}

	public int getDiscount2() {
		return discount2;
	}

	public void setDiscount2(int discount2) {
		this.discount2 = discount2;
	}

	public int getDiscount3() {
		return discount3;
	}

	public void setDiscount3(int discount3) {
		this.discount3 = discount3;
	}

	public AccountForm getAccountform() {
		return accountform;
	}

	public void setAccountform(AccountForm accountform) {
		this.accountform = accountform;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

	public Integer getItemcount() {
		return itemcount;
	}

	public void setItemcount(Integer itemcount) {
		this.itemcount = itemcount;
	}

	@Override
	public String toString() {
		return "MedItem [company=" + company + ", medicine=" + medicine + ", itemcount=" + itemcount + ", input_cost="
				+ input_cost + ", discount1=" + discount1 + ", discount2=" + discount2 + ", discount3=" + discount3
				+ ", AccountForm=" + accountform.getOid() + ", total=" + total + "]";
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
