package com.phoneWeb.entities;

import java.util.Date;

public class Orders {
	private Integer id;
	private User user;
	private Admin admin;
	private String address;
	private String code;
	private Product phone;
	private String email;
	private String payment;
	private String remark;
	private Date createdate;
	private int state;
	private Date treatedate;
	private String treateRemark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Product getPhone() {
		return phone;
	}
	public void setPhone(Product phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getTreatedate() {
		return treatedate;
	}
	public void setTreatedate(Date treatedate) {
		this.treatedate = treatedate;
	}
	public String getTreateRemark() {
		return treateRemark;
	}
	public void setTreateRemark(String treateRemark) {
		this.treateRemark = treateRemark;
	}
	
	
}
