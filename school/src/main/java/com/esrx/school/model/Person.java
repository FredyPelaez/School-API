package com.esrx.school.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Persons")
public class Person {
	
	@Id
	private String id;
	private String type;
	private String firstName;
	private String lastName;
	
}