package com.eapiis.main.ServiceLayer.Person;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonInsertRequest {
	private String firstName;
	private String surName;
	private String dni;
	private boolean gender;
	private Date birthDate;
}