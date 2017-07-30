package com.phoneWeb.service;

import java.util.List;

import org.hibernate.Query;

import com.phoneWeb.dao.AdminDao;
import com.phoneWeb.entities.Admin;
import com.phoneWeb.entities.Guestbook;
import com.phoneWeb.entities.News;
import com.phoneWeb.entities.Product;
import com.phoneWeb.entities.Productsort;

public class AdminService {
	private AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	public Admin validateDologin(String adminname,String passwd){
		return adminDao.validate(adminname, passwd);
	}
	
	public List<Admin> getAllAdmins(){
		return adminDao.getAllAdmins();
	}
	
	public Admin checkAdmin(String adminname){
		return adminDao.getAdmin(adminname);
	}
	
	public void Addadmin(Admin admin){
		adminDao.AddAdmin(admin);
	}
	
	public int Deladmin(int id){
		return adminDao.DelAdmin(id);
	}
	
	public int editAdmin(Admin admin){
		return adminDao.editAdmin(admin);
	}
	
	public int reloadPasswd(String adminname,String passwd){
		return adminDao.reloadPaawd(adminname, passwd);
	}
	
	public void AddNews(News news){
		adminDao.AddNews(news);
	}
	public List<News> getListNews(){
		return adminDao.getListNews();
	}
	
	
	public int delNews(int id){
		return adminDao.delNews(id);
	}
	public List<Guestbook> getListGbook(){
		return adminDao.getListGbook();
	}
	
	public int delGbook(int id){
		return adminDao.delGbook(id);
	}
	public Guestbook getGuestbook(int id){
		return adminDao.getGuestbook(id);
	}
	public void addProductsort(Productsort productsort){
		adminDao.addProductsort(productsort);
	}
	public void addProduct(Product product){
		adminDao.addProduct(product);
	}
	
	public List<Productsort> getListProductsort(){
		return adminDao.getListProductsort();
	}
	public List<Product> getListProduct(){
		return adminDao.getListProduct();
	}
	public int delphone(int id){	
		return adminDao.delphone(id);
	}
	public Product getOneProduct(int id){
		return adminDao.getOneProduct(id);
	}
}
