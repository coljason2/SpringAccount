package com.web.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APP_COMPANY")
@AttributeOverride(name = "id", column = @Column(name = "COMPANY_ID", nullable = false, columnDefinition = "BIGINT UNSIGNED"))
public class Company extends BaseMode {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3135578605335625789L;

	@Column(name = "COM_NAME", nullable = false)
	private String com_name;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "COMPANY_ID")
	private List<Medicine> Medicines;

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}

	public List<Medicine> getMedicines() {
		return Medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		Medicines = medicines;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", com_name=" + com_name + ", Medicines=" + Medicines + "]";
	}

}
