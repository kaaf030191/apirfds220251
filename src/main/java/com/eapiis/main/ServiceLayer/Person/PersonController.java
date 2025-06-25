package com.eapiis.main.ServiceLayer.Person;

import java.util.Date;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eapiis.main.Entity.Person;
import com.eapiis.main.Entity.Phone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	@PostMapping(path = "/insert", consumes = "multipart/form-data")
	public ResponseEntity<PersonInsertResponse> actionInsert(@Valid @ModelAttribute PersonInsertRequest request, BindingResult bindingResult) {
		PersonInsertResponse response = new PersonInsertResponse();

		if (bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(error -> {
				response.listMessage.add(error.getDefaultMessage());
			});

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		Person person = new Person();

		person.setIdPerson(UUID.randomUUID().toString());
		person.setFirstName(request.getFirstName());
		person.setSurName(request.getSurName());
		person.setDni(request.getDni());
		person.setGender(request.isGender());
		person.setBirthDate(new java.sql.Date(request.getBirthDate().getTime()));
		person.setCreatedAt(new java.sql.Timestamp(new Date().getTime()));
		person.setUpdatedAt(person.getCreatedAt());

		entityManager.persist(person);

		for(PersonInsertRequest.Phone item: request.getListPhone()) {
			Phone phone = new Phone();

			phone.setIdPhone(UUID.randomUUID().toString());
			phone.setIdPerson(person.getIdPerson());
			phone.setIdProvider(item.getIdProvider());
			phone.setNumber(item.getNumber());
			phone.setCreatedAt(new java.sql.Timestamp(new Date().getTime()));
			phone.setUpdatedAt(phone.getCreatedAt());

			entityManager.persist(phone);
		}

		response.type = "success";
		response.listMessage.add("Operación realizada correctamente.");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Transactional
	@PostMapping(path = "/update", consumes = "multipart/form-data")
	public ResponseEntity<PersonUpdateResponse> actionUpdate(@ModelAttribute PersonUpdateRequest request) {
		PersonUpdateResponse response = new PersonUpdateResponse();

		Person person = entityManager.find(Person.class, request.getIdPerson());

		person.setFirstName(request.getFirstName());
		person.setSurName(request.getSurName());
		person.setDni(request.getDni());
		person.setGender(request.isGender());
		person.setBirthDate(new java.sql.Date(request.getBirthDate().getTime()));
		person.setUpdatedAt(new java.sql.Timestamp(new Date().getTime()));

		entityManager.merge(person);

		entityManager.createQuery("delete from Phone p where p.idPerson = :idPerson")
			.setParameter("idPerson", request.getIdPerson()).executeUpdate();

		for(PersonUpdateRequest.Phone item: request.getListPhone()) {
			Phone phone = new Phone();

			phone.setIdPhone(UUID.randomUUID().toString());
			phone.setIdPerson(person.getIdPerson());
			phone.setIdProvider(item.getIdProvider());
			phone.setNumber(item.getNumber());
			phone.setCreatedAt(new java.sql.Timestamp(new Date().getTime()));
			phone.setUpdatedAt(phone.getCreatedAt());

			entityManager.persist(phone);
		}

		response.type = "success";
		response.listMessage.add("Operación realizada correctamente.");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/getall")
	public ResponseEntity<PersonGetAllResponse> actionGetAll() {
		PersonGetAllResponse response = new PersonGetAllResponse();

		response.dto.listPerson = entityManager.createQuery("select p from Person p left join fetch p.listPhone lp left join fetch lp.provider", Person.class).getResultList();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Transactional
	@DeleteMapping(path = "/delete/{idPerson}")
	public ResponseEntity<PersonDeleteResponse> actionDelete(@PathVariable String idPerson) {
		PersonDeleteResponse response = new PersonDeleteResponse();

		entityManager.createQuery("delete from Person p where p.idPerson = :idPerson")
			.setParameter("idPerson", idPerson).executeUpdate();

		response.type = "success";
		response.listMessage.add("Operación realizada correctamente.");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}