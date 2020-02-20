package com.esrx.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.esrx.school.model.Class;

@Repository
public interface ClassRepository extends MongoRepository<Class, String>{

	Class findByClassName(String className);

}
