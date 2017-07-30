package com.phoneWeb.entities;

public class Productsort {
	private Integer id;
	private String fatherId;
	private Product phone;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFatherId() {
		return fatherId;
	}
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}
	public Product getPhone() {
		return phone;
	}
	public void setPhone(Product phone) {
		this.phone = phone;
	}
	
	
}
