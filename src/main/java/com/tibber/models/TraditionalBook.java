package com.tibber.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.tibbers.utils.TraditionalBookId;

@Entity
@Table(name="traditional_book")
@EntityListeners(AuditingEntityListener.class)
public class TraditionalBook {
	
	//private String publisherName;
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id", insertable=false, updatable=false)
	private Publisher publisher;
	
	@Column(name="ISBN")
	private String isbn;
	
	@Column(name="publisher_id")
	private Integer publisherId;

	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, mappedBy="traditionalBook")
	private Book book;
	
	public Long getId() {
		return id;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}
	
	
	
	
	
}
