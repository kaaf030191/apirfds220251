package com.eapiis.main.ServiceLayer.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class PersonUpdateRequest {
	private String idPerson;
	private String firstName;
	private String surName;
	private String dni;
	private boolean gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	private List<Phone> listPhone = new ArrayList<>();

	public static class Phone {
		private String idProvider;
		private String number;

		public String getIdProvider() {
			return idProvider;
		}

		public void setIdProvider(String idProvider) {
			this.idProvider = idProvider;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}
	}

	public String getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(String idPerson) {
		this.idPerson = idPerson;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public List<Phone> getListPhone() {
		return listPhone;
	}

	public void setListPhone(List<Phone> listPhone) {
		this.listPhone = listPhone;
	}
}