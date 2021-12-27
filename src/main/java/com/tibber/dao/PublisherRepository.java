package com.tibber.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tibber.models.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {
	@Query(value="select p from Publisher p where p.publisherName = :name")
	public Publisher find(String name);
	
}
