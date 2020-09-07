package com.microservice.producermicroservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.producermicroservice.entity.Product;

@Repository
public interface ProducerRepository extends CrudRepository<Product, Integer>{
//for other db query logic
}
