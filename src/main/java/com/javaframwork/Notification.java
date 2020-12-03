package com.javaframwork;

public class Notification {

	private String response;
	private Integer status;
	
	
	public Notification(String response, Integer status) {
		super();
		this.response = response;
		this.status = status;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
