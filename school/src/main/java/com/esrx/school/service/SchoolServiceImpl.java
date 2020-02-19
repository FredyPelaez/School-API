package com.esrx.school.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.esrx.school.model.Person;
import com.esrx.school.repository.SchoolRepository;

@Service
public class SchoolServiceImpl {

	@Autowired
	private KafkaTemplate<String, String> KafkaTemplate;
	
	@Autowired
	SchoolRepository repository;
	
	String kafkaTopic = "java-topic-app";
	
	final static Logger logger = LogManager.getLogger(SchoolServiceImpl.class);

	
	public void send(String message) {
		KafkaTemplate.send(kafkaTopic, message);
	}
	
	public List<Person> getPersons(String firstName) {
		List<Person> persons = new ArrayList<>();

		if (StringUtils.isNotBlank(firstName)) {
			persons = repository.findByFirstName(firstName);
			if (!CollectionUtils.isEmpty(persons))
				return persons;
		}

		logger.warn("No person was found for given name.");

		persons = repository.findAll();
		
		logger.info(persons);

		logger.debug("Records found on DB - " + persons.toString());
		return persons;
	}
}
