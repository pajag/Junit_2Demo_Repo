package com.example.junit.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.junit.demo.model.Person;


public interface PersonRepository extends JpaRepository<Person, Integer> {

	 @Query("SELECT CASE WHEN COUNT(s) < 0 THEN TRUE ELSE FALSE END FROM Person s WHERE s.personId = ?1")
	 Boolean isPersonExitsById(Integer id);
	 @Query(value="select * from person where person_name=:name",nativeQuery = true)
	 Optional<Person> findByPersonName(@Param("name") String name);
	 
	 Optional<Person> findByPersonId(String name);
}
