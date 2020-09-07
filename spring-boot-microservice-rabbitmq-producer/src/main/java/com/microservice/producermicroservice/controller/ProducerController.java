package com.microservice.producermicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.producermicroservice.entity.Product;
import com.microservice.producermicroservice.service.ProducerService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("product")
public class ProducerController {

	@Autowired
	private ProducerService producerService;

	@PostMapping
	public String publishProductMessage(@RequestBody Product product) {
		return producerService.publishProductMessage(product);//View readme
	}

}
