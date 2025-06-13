package com.eapiis.main.ServiceLayer.Person;

import java.util.Date;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eapiis.main.Entity.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/person")
public class PersonController {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@PostMapping(path = "/insert", consumes = "multipart/form-data")
	public ResponseEntity<PersonInsertResponse> actionInsert(@ModelAttribute PersonInsertRequest request) {
		PersonInsertResponse response = new PersonInsertResponse();

		Person person = new Person();

		person.setIdPerson(UUID.randomUUID().toString());
		person.setFirstName(request.getFirstName());
		person.setSurName(request.getSurName());
		person.setDni(request.getDni());
		person.setGender(request.isGender());
		person.setBirthDate(new java.sql.Date(new Date().getTime()));
		person.setCreatedAt(new java.sql.Timestamp(new Date().getTime()));
		person.setUpdatedAt(person.getCreatedAt());

		entityManager.persist(person);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/getall")
	public ResponseEntity<PersonGetAllResponse> actionGetAll() {
		PersonGetAllResponse response = new PersonGetAllResponse();

		response.dto.listPerson = entityManager.createQuery("select p from Person p", Person.class).getResultList();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping(path = "/delete/{idPerson}")
	public ResponseEntity<PersonDeleteResponse> actionDelete(@PathVariable String idPerson) {
		PersonDeleteResponse response = new PersonDeleteResponse();

		entityManager.createQuery("delete from Person p where p.idPerson = :idPerson")
			.setParameter("idPerson", idPerson).executeUpdate();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}