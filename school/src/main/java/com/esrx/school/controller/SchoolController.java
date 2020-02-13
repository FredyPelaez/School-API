package com.esrx.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esrx.school.service.SchoolServiceImpl;

@RestController
@RequestMapping(value = "/")
public class SchoolController {

	@Autowired
	SchoolServiceImpl schoolService;
	
	@GetMapping(value = "/producer")
	public String producer(@RequestParam("message") String message) {
		schoolService.send(message);
		
		return "message send to Kafka Topic 'java-topic-app' succesfuly";
	}
	
}
