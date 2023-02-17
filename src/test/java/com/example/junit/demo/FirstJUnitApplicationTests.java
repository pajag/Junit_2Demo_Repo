package com.example.junit.demo;

import static org.assertj.core.api.Assertions.assertThatCollection;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.junit.demo.model.Person;
import com.example.junit.demo.repo.PersonRepository;
import com.example.junit.demo.service.PersonService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class FirstJUnitApplicationTests {

	@Autowired
	private  PersonRepository personRepository;

	@Autowired
	private  PersonService personService;

	Person person1 = null;
	Person person2 = null;
	Person person3 = null;
	Person person4 = null;

	@BeforeEach
	  void setUp() {

		personService = new PersonService(personRepository);
	}

	@Test
//	@Order(3)
	void testAllPerson() {
		List<Person> list = new ArrayList<>();
		person1 = new Person(1, "guru", "chennai");
		person2 = new Person(2, "gaja", "Tnagar");
		list.add(person1);
		list.add(person2);
		System.out.println("\ntestAllPerson : " + personService.getAllPerson().containsAll(list));
		assertTrue(personService.getAllPerson().containsAll(list));
		assertThatCollection(personService.getAllPerson());
	}

	
	@Test
//	@Order(6)
	void testgetAllPerons() {
		System.out.println(personService.getAllPerson().size());
		System.out.println("\ntestgetAllPerons : " + personService.getAllPerson().isEmpty());
		assertTrue(!personService.getAllPerson().isEmpty());
	}

	@Test
//	@Order(4)
	void testFindByPerons() {
		Integer nums = 1;
		System.out.println("\ntestFindByPerons :" + personService.getByIdPerson(nums));
		assertNotNull(personService.getByIdPerson(nums));
	}

	@Test
//	@Order(2)
	void testSaveByPerons() {
		person1 = new Person(3, "thiru", "banglore");
		person2 = new Person(4, "mani", "pune");
		System.out.println("\ntestSaveByPerons :" + personService.savePerson(person2));
		assertEquals(person2, personService.savePerson(person2));
	}

	@Test
//	@Order(5)
	void testFindByPersonName() {
		person1 = new Person(3, "thiru", "banglore");
		person2 = new Person(4, "mani", "pune");
		System.out.println("\ntestFindByPersonName :" + personService.findByPersonName(person2.getPersonName()));
		assertNotEquals(person1.getPersonName(),
				personService.findByPersonName(person2.getPersonName()).getPersonName());
	}

//	@Test
//	void testDeleteByPersonName() {
//		Person person1 = new Person(3, "thiru", "banglore");
//		Person person2 = new Person(4, "mani", "pune");
////		personService.deleteByPersonId(person2.getPersonId());
//		assertNull(personService.findByPersonId(person2.getPersonId().toString()));
//	}

	@AfterEach
	void testAfterAllPerson() {
		Person person1 = new Person(1, "guru", "chennai");
		Person person2 = new Person(2, "gaja", "Tnagar");
		Person person3 = new Person(3, "thiru", "banglore");
		Person person4 = new Person(5, "kathir", "tiruchi");
		List<Person> list = new ArrayList<>();
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.add(person4);
		System.out.println("\ntestAfterAllPerson : " + personService.getAllPerson().containsAll(list));
		assertTrue(personService.getAllPerson().containsAll(list));
	}

//	@Test
//	@Order(1)
	@RepeatedTest(value = 3, name = "{displayName}-{currentRepetition}/{totalRepetitions}")
	@DisplayName("TESTING MULTIPLE")
	void testTestInfo(TestInfo info) {
		System.out.println("TestInfo >>>>>>>>>>>>>>>>>>>>:" + info.getTestClass().get().getName());
		System.out.println("TestInfo >>>>>>>>>>>>>>>>>>>>:" + info.getTestMethod().get().getName());
		System.out.println("TestInfo >>>>>>>>>>>>>>>>>>>>:" + info.getDisplayName());
	}

	@Test
	@Tag("dev")
	void testTagB(TestInfo info) {

		System.out.println("Hello Dev_B");
	}

	@Test
	@Tag("prod")
	void testTagA(TestInfo info) {

		System.out.println("Hello Prod_A");
	}

	

}
