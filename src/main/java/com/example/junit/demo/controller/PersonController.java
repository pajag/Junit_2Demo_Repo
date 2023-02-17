package com.example.junit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.junit.demo.model.Person;
import com.example.junit.demo.model.PersonDto;
import com.example.junit.demo.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {

	@Autowired
	PersonService personService;

	@GetMapping("/get/all/persons")
	public ResponseEntity<?> getAllPerson() {
		return ResponseEntity.ok(personService.getAllPerson());

	}

	@GetMapping("/get")
	public ResponseEntity<?> getAllPersonId(@RequestParam(value="id") Integer id) {
		
		return ResponseEntity.ok(personService.getByIdPerson(id));
		
}
	@GetMapping("/get/city")
	public ResponseEntity<?> getAllPersonCity(@RequestParam(value="city") String city) {
		
		return ResponseEntity.ok(personService.getByPersonCity(city));
		
}

	@PostMapping("/save")
	public ResponseEntity<?> savePerson(@RequestBody PersonDto Dto) {
		Person person = new Person(Dto.getId(), Dto.getName(), Dto.getCity());
		return ResponseEntity.ok(personService.savePerson(person));

	}
}
