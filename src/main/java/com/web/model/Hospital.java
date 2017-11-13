package com.web.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "APP_HOSPITAL")
@AttributeOverride(name = "id", column = @Column(name = "HOSPITAL_ID", nullable = false))
public class Hospital extends BaseMode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6451926421250969545L;

	@NotNull(message = "醫院名稱不能為空值")
	@NotEmpty(message = "醫院名稱不能為空白")
	@Column(name = "HOS_NAME", nullable = false)
	private String hos_name;

	@OneToMany
	@Column(name = "HOSPITAL_ID")
	private List<AccountForm> AccountFroms;

	public Hospital(String string) {
		hos_name = string;
	}

	public Hospital() {
		super();
	}

	public String getHos_name() {
		return hos_name;
	}

	public void setHos_name(String hos_name) {
		this.hos_name = hos_name;
	}

	public List<AccountForm> getAccountFroms() {
		return AccountFroms;
	}

	public void setAccountFroms(List<AccountForm> accountFroms) {
		AccountFroms = accountFroms;
	}

	@Override
	public String toString() {
		return "Hospital [hos_name=" + hos_name + ", id=" + id + "]";
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
