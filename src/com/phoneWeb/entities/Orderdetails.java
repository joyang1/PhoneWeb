package com.phoneWeb.entities;

public class Orderdetails {
	private Integer id;
	private Orders orders;
	private User user;
	private Product phone;
	private float price;
	private int num;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getPhone() {
		return phone;
	}
	public void setPhone(Product phone) {
		this.phone = phone;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}	
}
