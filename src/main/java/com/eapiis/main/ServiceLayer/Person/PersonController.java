package com.eapiis.main.ServiceLayer.Person;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
	@PostMapping(path = "/insert", consumes = "multipart/form-data")
	public ResponseEntity<PersonInsertResponse> actionInsert(@ModelAttribute PersonInsertRequest request) {
		PersonInsertResponse response = new PersonInsertResponse();

		System.out.println(request.getFirstName());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}