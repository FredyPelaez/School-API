package com.esrx.school.producer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class CalificationRequestProducer {

	@Autowired
	private KafkaTemplate<String, String> KafkaTemplate;
	
	final static Logger logger = LogManager.getLogger(CalificationRequestProducer.class);
	
	String kafkaTopic = "calification-request";
	
	public void send(String message) {
		KafkaTemplate.send(kafkaTopic, message);
	}
}
