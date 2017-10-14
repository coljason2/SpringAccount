package com.web.vo;

public class JSONmedItem {

	private String company;
	private String inputday;
	private String name;
	private int cost;
	private int count;
	private int discount1;
	private int discount2;
	private int discount3;
	private int total;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getInputday() {
		return inputday;
	}

	public void setInputday(String inputday) {
		this.inputday = inputday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "JSONmedItem [company=" + company + ", inputday=" + inputday + ", name=" + name + ", cost=" + cost
				+ ", count=" + count + ", discount1=" + discount1 + ", discount2=" + discount2 + ", discount3="
				+ discount3 + ", total=" + total + "]";
	}

}
