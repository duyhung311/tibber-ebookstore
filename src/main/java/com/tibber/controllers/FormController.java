package com.tibber.controllers;

import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.tibber.dao.DateValidator;
import com.tibber.models.Book;
import com.tibber.models.Ebook;
import com.tibber.models.Publisher;
import com.tibber.models.TraditionalBook;
import com.tibber.services.BookService;
import com.tibber.services.EbookService;
import com.tibber.services.PublisherService;
import com.tibber.services.TraditionalBookService;
import com.tibbers.utils.DateValidatorUsingDateFormat;

import dto.AddBookDto;

@Controller
@RequestMapping("/")
public class FormController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private PublisherService publisherService;
	@Autowired
	private TraditionalBookService tBookService;
	@Autowired
	private EbookService eBookService;
	
	@GetMapping("/")
	public String showRegister(Model model) {
		ArrayList<Publisher> publishers = publisherService.getAll();
		System.out.println(publishers.get(4).getPublisherName());
		AddBookDto bookdto = new AddBookDto();
		model.addAttribute("dto", bookdto);
		model.addAttribute("publishers", publishers);
	    return "add-book-form";
	}
	
	@PostMapping("/new")
	public String checkRegister(@ModelAttribute("dto") AddBookDto dto, BindingResult binding) {
	  if(binding.hasErrors())
		  return "add-book-form";
	  bookService.saveBook(dto.getBook());
	  System.out.println(dto.getPublisher().getPublisherName());
	  if(dto.getPublisher() != null && dto.getBook().getTbook_flag() != null) {
		  TraditionalBook newTBook = new TraditionalBook();
		  newTBook.setIsbn(dto.getBook().getISBN());
		  Integer pubId = publisherService.findForId(dto.getPublisher().getPublisherName());
		  newTBook.setPublisherId(pubId);
		  tBookService.saveTbook(newTBook);
	  }
	  if(dto.getBook().getEbook_flag()!=null) {
		  Ebook ebook = new Ebook();
		  ebook.setIsbn(dto.getBook().getISBN());
		  ebook.setLinkForRent("www.abcd.com/rent" + dto.getBook().getISBN());
		  ebook.setLinkForBuy("www.abcd.com/buy" + dto.getBook().getISBN());
		  eBookService.saveEBook(ebook);
	  }
	  return "redirect:/inventory";
	}
	
	
}
