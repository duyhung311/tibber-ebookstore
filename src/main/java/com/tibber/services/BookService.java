package com.tibber.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tibber.dao.BookRepository;
import com.tibber.models.Book;

@Service
public class BookService {
	@Autowired
	private BookRepository repo;

	public void saveBook(Book b) {
		Book newBook = new Book();
		newBook.setISBN(b.getISBN());
		newBook.setRelease_date(b.getRelease_date());
		newBook.setTitle(b.getTitle());
		newBook.setGenre(b.getGenre());
		if(b.getEbook_flag()!= null)
			newBook.setEbook_flag(1);
		else newBook.setEbook_flag(0);
		if(b.getTbook_flag()!=null)
			newBook.setTbook_flag(1);
		else newBook.setTbook_flag(0);
		
		repo.save(newBook);
	}
	
	public List<Book> getAll() {
		return (ArrayList<Book>) repo.getAll();
	}
	
	
	
}
