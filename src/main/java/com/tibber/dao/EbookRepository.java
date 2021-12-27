package com.tibber.dao;

import org.springframework.data.repository.CrudRepository;

import com.tibber.models.Ebook;

public interface EbookRepository extends CrudRepository<Ebook, Integer> {

}
