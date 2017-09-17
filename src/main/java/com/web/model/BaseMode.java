package com.web.model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public abstract class BaseMode implements Serializable, Comparator<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false, columnDefinition = "uuid")
	protected UUID id;

	@Column(name = "version")
	@Version
	private Long version;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CRE_DATE")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UP_DATE")
	private Date updateDate;

	@Column(name = "OID")
	private String oid;

	public String getCreateDate() {
		String date = createDate + "";
		return date.substring(0, 10);
	}

	public UUID getId() {
		return id;
	}

	public Long getVersion() {
		return version;
	}

	@PrePersist
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {

		String date = updateDate + "";
		return date.substring(0, 10);
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	@PreUpdate
	public void setUpdateDate(Date updateDate) {
		this.updateDate = new Date();
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.getId() != null ? this.getId().hashCode() : 0);

		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object)
			return true;
		if (object == null)
			return false;
		if (getClass() != object.getClass())
			return false;

		BaseMode other = (BaseMode) object;
		if (this.getId() != other.getId() && (this.getId() == null || !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "BaseMode [id=" + id + ", version=" + version + ", createDate=" + createDate + ", updateDate="
				+ updateDate + ", oid=" + oid + "]";
	}

}
