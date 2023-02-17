package com.example.junit.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="person")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Person {

	@Id
	@Column(name="person_id")
	private Integer personId;
	@Column(name="person_name")
	private String personName;
	@Column(name="person_city")
	private String personCity;
}
