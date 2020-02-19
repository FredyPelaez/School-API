package com.esrx.school.mapper;

import com.esrx.school.domain.CreateStudentRequest;
import com.esrx.school.model.Person;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class StudentMapper {
	public Person map(CreateStudentRequest request) {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.classMap(CreateStudentRequest.class,  Person.class).toClassMap();
		MapperFacade mapper= mapperFactory.getMapperFacade();
		Person persons = mapper.map(request, Person.class);
		return persons;
	}
}
