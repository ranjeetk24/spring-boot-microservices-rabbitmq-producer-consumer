package com.microservice.consumermicroservice.facade;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.consumermicroservice.entity.Product;

@Repository
public interface ConsumerRepository extends CrudRepository<Product, Integer>{

}
