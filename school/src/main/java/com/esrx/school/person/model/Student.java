package com.esrx.school.person.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@JsonProperty
	@NotNull
	private long id;
	@JsonProperty
	@NotNull
	private String firstName;
	@JsonProperty
	@NotNull
	private String lastName;
	
}