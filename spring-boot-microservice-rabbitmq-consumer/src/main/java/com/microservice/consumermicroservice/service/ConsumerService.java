package com.microservice.consumermicroservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.microservice.consumermicroservice.entity.Product;
import com.microservice.consumermicroservice.facade.ConsumerRepository;

@Service
public class ConsumerService {
	private static final Logger log = LogManager.getLogger(ConsumerService.class);
	public static final String PRODUCT_QUEUE = "product-queue";
	private ConsumerRepository productRepository;

	public ConsumerService(ConsumerRepository productRepository) {
		this.productRepository = productRepository;
	}

	@RabbitListener(queues = PRODUCT_QUEUE)
	public void receiveMessageAndCreateProduct(Product product) {
		log.info("Message received :" + product.getProductName());		
		product.setMessageReceived(true);	
		productRepository.save(product);

		log.info("Message processed...and saved in database");
	}



	public Product delete(int id) {
		Product pd = findById(id);
		if (pd != null) {
			productRepository.delete(pd);
		}
		return pd;
	}

	public List<Product> findAll() {
		List<Product> pdList = new ArrayList<Product>();
		productRepository.findAll().forEach(pdList::add);
		return pdList;
	}

	public Product findById(int id) {
		Optional<Product> pd = productRepository.findById(id);
		return pd.get();
	}

	public Product update(Product pd) {
		return null;//TDOD
	}

}
