package com.flight.booking.service;

import java.util.Date;

public class ErrorMessage {
	
	private String message;
	private String description;
	private Date occurredTime;
	
	public ErrorMessage()
	{}
	
	public ErrorMessage(String message, String description, Date occurredTime) {
		this.message = message;
		this.description = description;
		this.occurredTime = occurredTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getOccurredTime() {
		return occurredTime;
	}
	public void setOccurredTime(Date occurredTime) {
		this.occurredTime = occurredTime;
	}
	
	

}
