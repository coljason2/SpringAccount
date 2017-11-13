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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "APP_COMPANY")
@AttributeOverride(name = "id", column = @Column(name = "COMPANY_ID", nullable = false))
public class Company extends BaseMode {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3135578605335625789L;

	@NotNull(message = "藥廠名稱不能為空白!")
	@NotEmpty(message = "藥廠名稱不能為空白!")
	@Column(name = "COM_NAME", nullable = false)
	private String com_name;

	@OneToMany
	@JoinColumn(name = "COMPANY_ID")
	private List<Medicine> Medicines;

	public Company(String string) {
		com_name = string;
	}

	public Company() {
		super();
	}

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
		return "Company [id=" + id + ", com_name=" + com_name + "]";
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
