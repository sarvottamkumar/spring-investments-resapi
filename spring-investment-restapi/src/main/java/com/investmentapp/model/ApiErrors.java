package com.investmentapp.model;

import java.time.LocalDateTime;
import java.util.List;

public class ApiErrors {
	
	LocalDateTime timestamp;
	String message;
	int status;
	List<String> error;
	public ApiErrors() {
		super();
		
	}
	
	public ApiErrors(LocalDateTime timestamp, String message, int status, List<String> error) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.error = error;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<String> getError() {
		return error;
	}
	public void setError(List<String> error) {
		this.error = error;
	}
	
	@Override
	public String toString() {
		return "ApiErrors [timestamp=" + timestamp + ", message=" + message + ", status=" + status + ", error=" + error
				+ "]";
	}
	
	

}
