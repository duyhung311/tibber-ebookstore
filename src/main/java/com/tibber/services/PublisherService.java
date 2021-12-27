package com.tibber.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibber.dao.PublisherRepository;
import com.tibber.models.Publisher;

@Service
public class PublisherService {
	@Autowired
	private PublisherRepository pubRepo;
	
	public Publisher findPublisher(String name) {
		return pubRepo.find(name);
	}
	
	public ArrayList<Publisher> getAll() {
		return (ArrayList<Publisher>) pubRepo.findAll();
	}
	
	public Integer findForId(String name) {
		return pubRepo.find(name).getPublisherId();
	}
	
	public void savePublisher(Publisher pub) {
		pubRepo.save(pub);
	}
}
