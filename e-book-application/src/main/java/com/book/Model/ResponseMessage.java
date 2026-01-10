package com.book.Model;

import java.util.List;

public class ResponseMessage {
	
	private Integer statusCode;
	private String message;
	private String status;
	private Object data;
	
	public Integer getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}



	
	public ResponseMessage(Integer statusCode, String status, String message, Object data) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.status = status;
		this.data = data;
	}
	
	
	public ResponseMessage(Integer statusCode, String status) {
		super();
		this.statusCode = statusCode;
		this.status = status;
	}
	
	


	

}
