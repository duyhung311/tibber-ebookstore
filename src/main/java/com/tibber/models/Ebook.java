package com.tibber.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ebook")
public class Ebook {
	@Id
	@Column
	private String isbn;
	
	@Column(name="link_for_rent")
	private String linkForRent;
	
	@Column(name="link_for_buy")
	private String linkForBuy;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getLinkForRent() {
		return linkForRent;
	}

	public void setLinkForRent(String linkForRent) {
		this.linkForRent = linkForRent;
	}

	public String getLinkForBuy() {
		return linkForBuy;
	}

	public void setLinkForBuy(String linkForBuy) {
		this.linkForBuy = linkForBuy;
	}
	
	
}
