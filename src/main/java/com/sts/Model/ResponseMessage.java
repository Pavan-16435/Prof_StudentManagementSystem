package com.sts.Model;

import java.util.List;

public class ResponseMessage {
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	private int statusCode;
	private String status;
	private Object data;
	private String message;
	private List<?> list;
	

	public ResponseMessage(int statusCode, String status, String message) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.message = message;
	}
	public ResponseMessage(int statusCode, String status, Object data, String message, List<?> list) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.data = data;
		this.message = message;
		this.list = list;
	}
	public ResponseMessage(int statusCode, String status, Object data, String message) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.data = data;
		this.message = message;
	}

	
	
	
}
