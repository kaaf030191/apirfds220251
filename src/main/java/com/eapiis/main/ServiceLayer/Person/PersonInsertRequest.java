package com.eapiis.main.ServiceLayer.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PersonInsertRequest {
	@NotBlank(message = "El campo \"firstName\" es requerido")
	private String firstName;
	@NotBlank(message = "El campo \"surName\" es requerido")
	private String surName;
	@NotBlank(message = "El campo \"dni\" es requerido")
	@Pattern(regexp = "^([0-9]{8})?$", message = "El campo \"dni\" no tiene un formato correcto")
	private String dni;
	@NotNull(message = "El campo \"gender\" es requerido")
	private Boolean gender;
	@NotNull(message = "El campo \"birthDate\" es requerido")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	@Valid
	@NotEmpty(message = "El campo \"listPhone\" no puede estar vacío")
	private List<Phone> listPhone = new ArrayList<>();

	public static class Phone {
		@NotBlank(message = "El campo \"idProvider\" es requerido")
		private String idProvider;
		@NotBlank(message = "El campo \"number\" es requerido")
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

	public Boolean isGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
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