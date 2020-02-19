package com.esrx.school.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esrx.school.model.Person;
import com.esrx.school.service.SchoolServiceImpl;

@RestController
@RequestMapping(value = "/")
public class SchoolController {

	@Autowired
	SchoolServiceImpl schoolService;
	
	final static Logger logger = LogManager.getLogger(SchoolController.class);	
	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		schoolService.send(message);
		
		return "message send to Kafka Topic 'java-topic-app' succesfuly";
	}
	
	@GetMapping("/persons")
	public List<Person> getPersons(@RequestParam(value = "firstName", required = false) String firstName) {
		logger.debug("Get users parameters - firstName=" + firstName);
		return schoolService.getPersons(firstName);
	}
}
