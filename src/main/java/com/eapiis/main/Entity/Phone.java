package com.eapiis.main.Entity;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tphone")
public class Phone {
	@Id
	@Column(name = "idPhone")
	private String idPhone;

	@Column(name = "idPerson")
	private String idPerson;
	
	@Column(name = "idProvider")
	private String idProvider;

	@Column(name = "number")
	private String number;

	@Column(name = "createdAt")
	private Timestamp createdAt;

	@Column(name = "updatedAt")
	private Timestamp updatedAt;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "idPerson", insertable = false, updatable = false)
	private Person person;

	@ManyToOne
	@JoinColumn(name = "idProvider", insertable = false, updatable = false)
	private Provider provider;

	public String getIdPhone() {
		return this.idPhone;
	}

	public void setIdPhone(String idPhone) {
		this.idPhone = idPhone;
	}

	public String getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(String idPerson) {
		this.idPerson = idPerson;
	}

	public String getIdProvider() {
		return this.idProvider;
	}

	public void setIdProvider(String idProvider) {
		this.idProvider = idProvider;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Provider getProvider() {
		return this.provider;
	}
}