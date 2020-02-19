package com.esrx.school.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "School")
public class School {
	
	@Id
	private String id;
	private String className;
	private String teacherID;
	private String [] studentIds;
	
}