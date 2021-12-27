package com.tibber.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tibber.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	@Query(value = "Select b from Book b ORDER BY id DESC ")
	public List<Book> getAll();
}
