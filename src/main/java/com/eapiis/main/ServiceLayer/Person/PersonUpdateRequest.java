package com.eapiis.main.ServiceLayer.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonUpdateRequest {
	private String idPerson;
	private String firstName;
	private String surName;
	private String dni;
	private boolean gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;

	private List<Phone> listPhone = new ArrayList<>();

	@Getter
	@Setter
	public static class Phone {
		private String idProvider;
		private String number;
	}
}