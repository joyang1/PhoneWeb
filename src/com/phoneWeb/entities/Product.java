package com.phoneWeb.entities;

import java.util.Date;


public class Product {
	private Integer id;
	private String phonename;
	private String phone;
	private String introduce;	
	private float price;
	private String phonebigimg;
	private String phonesmallimg;
	private int buynum;
	private Date ccdate;
	private Productsort productsort;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPhonename() {
		return phonename;
	}
	public void setPhonename(String phonename) {
		this.phonename = phonename;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPhonebigimg() {
		return phonebigimg;
	}
	public void setPhonebigimg(String phonebigimg) {
		this.phonebigimg = phonebigimg;
	}
	public String getPhonesmallimg() {
		return phonesmallimg;
	}
	public void setPhonesmallimg(String phonesmallimg) {
		this.phonesmallimg = phonesmallimg;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	public Date getCcdate() {
		return ccdate;
	}
	public void setCcdate(Date ccdate) {
		this.ccdate = ccdate;
	}
	public Productsort getProductsort() {
		return productsort;
	}
	public void setProductsort(Productsort productsort) {
		this.productsort = productsort;
	}
	
	
}
