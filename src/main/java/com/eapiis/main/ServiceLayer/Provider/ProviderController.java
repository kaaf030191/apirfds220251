package com.eapiis.main.ServiceLayer.Provider;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eapiis.main.Entity.Provider;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/provider")
public class ProviderController {
	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping(path = "/getall")
	public ResponseEntity<ProviderGetAllResponse> actionGetAll() {
		ProviderGetAllResponse response = new ProviderGetAllResponse();

		response.dto.listProvider = entityManager.createQuery("select p from Provider p", Provider.class).getResultList();

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}