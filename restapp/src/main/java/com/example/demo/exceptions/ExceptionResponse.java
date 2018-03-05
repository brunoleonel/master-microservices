package com.example.demo.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private List<Object> details;
	
	public ExceptionResponse() {
		this.details = new ArrayList<Object>();
	}

	public ExceptionResponse(Date timestamp, String message, List<Object> details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public ExceptionResponse addDetail(String detail) {
		this.details.add(detail);
		return this;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Object> getDetails() {
		return details;
	}
}
