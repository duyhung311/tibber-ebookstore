package com.tibber.dao;

import org.springframework.data.repository.CrudRepository;

import com.tibber.models.TraditionalBook;

public interface TraditionalBookRepository extends CrudRepository<TraditionalBook, Integer> {
	
}
