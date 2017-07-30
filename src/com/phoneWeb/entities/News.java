package com.phoneWeb.entities;

import java.util.Date;

public class News {
	private Integer id;
	private String title;
	private String content;
	private Date newsdate;
	private String newsimg;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getNewsdate() {
		return newsdate;
	}
	public void setNewsdate(Date newsdate) {
		this.newsdate = newsdate;
	}
	public String getNewsimg() {
		return newsimg;
	}
	public void setNewsimg(String newsimg) {
		this.newsimg = newsimg;
	}
	
	
}
