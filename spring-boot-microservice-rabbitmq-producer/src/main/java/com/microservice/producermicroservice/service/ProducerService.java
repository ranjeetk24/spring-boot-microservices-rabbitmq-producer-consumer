package com.microservice.producermicroservice.service;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Service;

import com.microservice.producermicroservice.ProducerMicroserviceApplication;
import com.microservice.producermicroservice.entity.Product;
import com.microservice.producermicroservice.repository.ProducerRepository;

@Service
public class ProducerService {

	@Autowired
	private ProducerRepository repository;

	@Autowired
	private RabbitMessagingTemplate rabbitMessagingTemplate;
	@Autowired
	private MappingJackson2MessageConverter mappingJackson2MessageConverter;

	public String publishProductMessage(Product product) {
		this.rabbitMessagingTemplate.setMessageConverter(this.mappingJackson2MessageConverter);
		this.rabbitMessagingTemplate.convertAndSend(ProducerMicroserviceApplication.PRODUCT_EXCHANGE, ProducerMicroserviceApplication.PRODUCT_ROUTING_KEY,product);
		return "Product Message Published";
	}


}
