package com.microservice.consumermicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.consumermicroservice.entity.Product;
import com.microservice.consumermicroservice.service.ConsumerService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("consumer")
public class ConsumerController {

	@Autowired
	private ConsumerService consumerService;

	@GetMapping
	public List<Product> fildAll() {

		return consumerService.findAll();
	}

	@PutMapping
	public Product update(@RequestBody Product user) {
		return consumerService.update(user);
	}

	@DeleteMapping(path = { "/{id}" })
	public void delete(@PathVariable("id") int id) {
		consumerService.delete(id);

	}

	@GetMapping(path = { "/{id}" })
	public Product findUser(@PathVariable("id") int id) {
		return consumerService.findById(id);
	}

}
