package com.tibber.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "publisher")
public class Publisher {
	@Id
	@Column(name="publisher_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer publisherId;
	
	@OneToMany(targetEntity = TraditionalBook.class, cascade=CascadeType.PERSIST)
	@JoinColumn(name = "publisher_id")
	private List<TraditionalBook> list = new ArrayList<TraditionalBook>();
	
	@Column(name="publisher_name")
	private String publisherName;

	@Column(name="publisher_email")
	private String publisherEmail;

	public List<TraditionalBook> getList() {
		return list;
	}

	public void setList(List<TraditionalBook> list) {
		this.list = list;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherEmail() {
		return publisherEmail;
	}

	public void setPublisherEmail(String publisherEmail) {
		this.publisherEmail = publisherEmail;
	}

	
}
