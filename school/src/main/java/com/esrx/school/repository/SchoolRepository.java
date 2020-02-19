package com.esrx.school.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.esrx.school.model.School;

@Repository
public interface SchoolRepository extends MongoRepository<School, String>{

	School findByClassName(String className);

}
