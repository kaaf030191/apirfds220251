package com.eapiis.main.Entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tperson")
public class Person {
	@Id
	@Column(name = "idPerson")
	private String idPerson;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "surName")
	private String surName;

	@Column(name = "dni")
	private String dni;

	@Column(name = "gender")
	private boolean gender;

	@Column(name = "birthDate")
	private Date birthDate;

	@Column(name = "createdAt")
	private Timestamp createdAt;

	@Column(name = "updatedAt")
	private Timestamp updatedAt;

	@JsonManagedReference
	@OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
	private List<Phone> listPhone;

	public String getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(String idPerson) {
		this.idPerson = idPerson;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return this.surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isGender() {
		return this.gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public List<Phone> getListPhone() {
		return this.listPhone;
	}

	public void setListPhone(List<Phone> listPhone) {
		this.listPhone = listPhone;
	}
}