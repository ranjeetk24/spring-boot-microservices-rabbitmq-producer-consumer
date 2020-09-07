package com.microservice.producermicroservice;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

@SpringBootApplication
@EnableDiscoveryClient
public class ProducerMicroserviceApplication {
	
	public static final String PRODUCT_EXCHANGE = "product-exchange";
	public static final String PRODUCT_QUEUE = "product-queue";
	public static final String PRODUCT_ROUTING_KEY = "product-routing-key";

	public static void main(String[] args) {
		SpringApplication.run(ProducerMicroserviceApplication.class, args);
	}
	
	@Bean
	Queue queue() {
		return new Queue(PRODUCT_QUEUE);
	}
	@Bean
	DirectExchange exchange() {
		return new DirectExchange(PRODUCT_EXCHANGE);
	}
	
	@Bean
	Binding binding(DirectExchange exchange,Queue queue) {
		return BindingBuilder.bind(queue).to(exchange).with(PRODUCT_ROUTING_KEY);
	}
	
	@Bean
	public MappingJackson2MessageConverter jackson2Converter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		return converter;
	}

}
