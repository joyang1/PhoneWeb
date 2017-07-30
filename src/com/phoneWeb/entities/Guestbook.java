package com.phoneWeb.entities;

import java.util.Date;

public class Guestbook {
	private Integer id;
	private User user;
	private String email;
	private String homepage;
	private String title;
	private String content;
	private Date createdate;
	private String revert;
	private Date revertdate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getRevert() {
		return revert;
	}
	public void setRevert(String revert) {
		this.revert = revert;
	}
	public Date getRevertdate() {
		return revertdate;
	}
	public void setRevertdate(Date revertdate) {
		this.revertdate = revertdate;
	}
	
	
}
