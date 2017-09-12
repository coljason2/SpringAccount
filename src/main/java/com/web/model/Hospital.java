package com.web.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APP_HOSPITAL")
@AttributeOverride(name = "id", column = @Column(name = "HOSPITAL_ID", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class Hospital extends BaseMode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6451926421250969545L;

	@Column(name = "HOS_NAME", nullable = false)
	private String hos_name;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@Column(name = "HOSPITAL_ID")
	private List<AccountForm> AccountFroms;

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
		return "Hospital [hos_name=" + hos_name + ", AccountFroms=" + AccountFroms + ", id=" + id + "]";
	}

}
