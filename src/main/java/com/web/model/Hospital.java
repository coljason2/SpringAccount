package com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_HOSPITAL")
public class Hospital implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6451926421250969545L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HOSPITAL_ID")
	private Integer id;

	@Column(name = "HOS_NAME", nullable = false)
	private String hos_name;

	@Column(name = "CRE_NAME", nullable = false)
	private String createDate;

	@Column(name = "UP_NAME", nullable = false)
	private String updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHos_name() {
		return hos_name;
	}

	public void setHos_name(String hos_name) {
		this.hos_name = hos_name;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", hos_name=" + hos_name + ", createDate=" + createDate + ", updateDate="
				+ updateDate + "]";
	}

}
