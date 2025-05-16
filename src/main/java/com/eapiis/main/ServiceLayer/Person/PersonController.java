package com.eapiis.main.ServiceLayer.Person;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
	@GetMapping(path = "/getall")
	public ResponseEntity<PersonResponse> actionGetAll() {
		PersonResponse personResponse = new PersonResponse();

		personResponse.dto.welcome = "Hola mundo cruel!!!";

		return new ResponseEntity<>(personResponse, HttpStatus.OK);
	}
}