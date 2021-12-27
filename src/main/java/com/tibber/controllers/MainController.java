package com.tibber.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tibber.models.Book;
import com.tibber.models.Publisher;
import com.tibber.services.BookService;
import com.tibber.services.EbookService;
import com.tibber.services.PublisherService;
import com.tibber.services.TraditionalBookService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private TraditionalBookService tBookService;
	@Autowired
	private EbookService eBookService;
	
	@GetMapping("/inventory")
	public String showInventory(Model model, HttpServletRequest request) {
		List<Book> array = bookService.getAll();
		System.out.println(array.get(0).getEbook_flag());
		model.addAttribute("books", array);
		return "inventory";
	}
	
	@GetMapping("/publisher")
	public String initNewAuthor(Model model, HttpServletRequest request) {
		Publisher pub = new Publisher();
		model.addAttribute("publisher", pub);
		return "add-author";
	}
	
	@PostMapping("/savePub")
	public String savePublisher(@ModelAttribute("publisher") Publisher publisher) {
		publisherService.savePublisher(publisher);
		return "redirect:/inventory";
	}
}

