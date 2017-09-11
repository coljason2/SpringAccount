package com.web.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

//藥廠
@Entity
@Table(name = "APP_COMPANY")
public class Company implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3135578605335625789L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COMPANY_ID")
	private Integer id;

	@Column(name = "COM_NAME", nullable = false)
	private String com_name;

	@Generated(GenerationTime.INSERT)
	@Column(name = "CRE_DATE", insertable = false)
	private String createDate;

	@Generated(GenerationTime.ALWAYS)
	@Column(name = "UP_DATE", insertable = false, updatable = false)
	private String updateDate;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "COMPANY_ID")
	private List<Medicine> Medicines;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
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

	public List<Medicine> getMedicines() {
		return Medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		Medicines = medicines;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", com_name=" + com_name + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", Medicines=" + Medicines + "]";
	}

}
