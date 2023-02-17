package com.example.junit.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.junit.demo.model.Person;
import com.example.junit.demo.repo.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public List<Person> getAllPerson() {
		List<Person>  personlsit=personRepository.findAll();
		 return personlsit;
	}
	
	public Person getByIdPerson(Integer id) {
		Optional<Person> find= personRepository.findById(id);
		if(find.isEmpty()) {
			return null;
		}
		 return find.get();

	}
	
	public Person getByPersonCity(String city) {
		Optional<Person> find= personRepository.findByPersonCity(city);
		if(find.isEmpty()) {
			return null;
		}
		 return find.get();

	}
	
	public Person savePerson(Person person) {
		return personRepository.save(person);

	}
	
	public Person findByPersonName(String name) {
		Optional<Person> find= personRepository.findByPersonName(name);
		 return find.get();

	}
	
	public Person findByPersonId(String name) {
		Optional<Person> person=personRepository.findByPersonId(name);
		if(person.isEmpty()) {
			return null;
		}
		 return person.get();
	}
	
	public void deleteByPersonId(Integer id) {
		 personRepository.deleteById(id);
	
	}
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
}
