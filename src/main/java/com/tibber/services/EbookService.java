package com.tibber.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibber.dao.EbookRepository;
import com.tibber.models.Ebook;

@Service
public class EbookService {
	
	@Autowired
	private EbookRepository eRepo;
	
	public void saveEBook(Ebook ebook) {
		eRepo.save(ebook);
	}
}
