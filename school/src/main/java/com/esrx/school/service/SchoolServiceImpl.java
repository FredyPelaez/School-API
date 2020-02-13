package com.esrx.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SchoolServiceImpl {

	@Autowired
	private KafkaTemplate<String, String> KafkaTemplate;
	
	String kafkaTopic = "java-topic-app";
	
	public void send(String message) {
		KafkaTemplate.send(kafkaTopic, message);
	}
}
