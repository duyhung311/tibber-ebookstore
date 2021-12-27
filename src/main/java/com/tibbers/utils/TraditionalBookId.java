package com.tibbers.utils;

import java.io.Serializable;

import javax.persistence.Id;

import com.tibber.models.Publisher;


public class TraditionalBookId implements Serializable {
	@Id
	private Publisher publisher;
}
