package com.tibber.models;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "book")
public class Book {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ISBN")
	@Size(max=13)
	private String ISBN;
	
	private Date release_date;
	
	@NotBlank
	private String title;

	@NotBlank
	private String genre;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TraditionalBook getTraditionalBook() {
		return traditionalBook;
	}

	public void setTraditionalBook(TraditionalBook traditionalBook) {
		this.traditionalBook = traditionalBook;
	}

	private Integer ebook_flag;
	
	private Integer tbook_flag;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="ISBN" ,insertable=false, updatable=false)
	private TraditionalBook traditionalBook;
	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getEbook_flag() {
		return ebook_flag;
	}

	public void setEbook_flag(Integer ebook_flag) {
		this.ebook_flag = ebook_flag;
	}

	public Integer getTbook_flag() {
		return tbook_flag;
	}

	public void setTbook_flag(Integer tbook_flag) {
		this.tbook_flag = tbook_flag;
	}
	
	
	
}
