package com.eapiis.main.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tphone")
@Getter
@Setter
public class Phone {
	@Id
	@Column(name = "idPhone")
	private String idPhone;

	@Column(name = "idPerson")
	private String idPerson;
	
	@Column(name = "idProvider")
	private String idProvider;

	@Column(name = "createdAt")
	private Date createdAt;

	@Column(name = "updatedAt")
	private Date updatedAt;
}