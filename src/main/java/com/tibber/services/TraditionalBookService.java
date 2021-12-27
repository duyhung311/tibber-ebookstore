package com.tibber.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibber.dao.TraditionalBookRepository;
import com.tibber.models.TraditionalBook;

@Service
public class TraditionalBookService {
	@Autowired
	private TraditionalBookRepository repo;
	@Autowired
	private PublisherService pubService;
	
	
	public void saveTbook(TraditionalBook tbook) {
		repo.save(tbook);
	}	
}
