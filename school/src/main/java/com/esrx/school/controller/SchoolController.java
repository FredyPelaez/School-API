package com.esrx.school.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esrx.school.model.Person;
import com.esrx.school.model.Class;
import com.esrx.school.producer.CalificationRequestProducer;
import com.esrx.school.service.SchoolServiceImpl;

@RestController
@RequestMapping(value = "/")
public class SchoolController {

	@Autowired
	SchoolServiceImpl schoolService;
	
	@Autowired
	CalificationRequestProducer requestProducer;
	
	final static Logger logger = LogManager.getLogger(SchoolController.class);
	
	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		requestProducer.send(message);
		
		return "message send to Kafka Topic 'java-topic-app' succesfuly";
	}
	
	@GetMapping("/persons")
	public List<Person> getPersons(@RequestParam(value = "firstName", required = false) String firstName) {
		logger.debug("Get users parameters - firstName=" + firstName);
		return schoolService.getPersons(firstName);
	}
	
	@GetMapping("/class")
	public Class getClass(@RequestParam(value = "className") String className) {
		logger.debug("Get class " + className);
		return schoolService.getClass(className);
	}
	
	@GetMapping("/teacher")
	public Optional<Person> getTeacher(@RequestParam(value = "className") String className) {
		logger.debug("Get Teacher from class " + className);
		return schoolService.getTeacher(className);
	}
}
