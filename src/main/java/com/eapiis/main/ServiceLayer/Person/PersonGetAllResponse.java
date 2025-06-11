package com.eapiis.main.ServiceLayer.Person;

import java.util.ArrayList;
import java.util.List;

import com.eapiis.main.Entity.Person;

public class PersonGetAllResponse {
	public class Dto {
		public List<Person> listPerson = new ArrayList<>();
	}

	public Dto dto = new Dto();
}
