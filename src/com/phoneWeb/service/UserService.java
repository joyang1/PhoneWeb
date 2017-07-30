package com.phoneWeb.service;

import java.util.List;









import org.hibernate.Query;

import com.phoneWeb.dao.UserDao;
import com.phoneWeb.entities.Guestbook;
import com.phoneWeb.entities.News;
import com.phoneWeb.entities.Orders;
import com.phoneWeb.entities.Product;
import com.phoneWeb.entities.Productsort;
import com.phoneWeb.entities.User;

public class UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void AddUser(User user){
		userDao.AddUser(user);
	}
	
	public void jihuo(String email){
		userDao.jihuo(email);
	}
	public List<News> getListNNews(){
		return userDao.getListNNews();
	}
	public List<News> getListNNews(int pageNumber, int pageSize){
		return userDao.getListNNews(pageNumber,pageSize);
	}
	public News getOneNews(int id){
		return userDao.getOneNews(id);
	}
	public News getOneNews(){
		return userDao.getOneNews();
	}
	public void addGuessbook(Guestbook guestbook){
		userDao.addGuessbook(guestbook);
	}
	
	public List<Product> getListFProduct(){
		return userDao.getListFProduct();
	}
	public List<Product> getListRXProduct(){
		return userDao.getListRXProduct();
	}
	public List<Product> getListMaxProduct(){
		return userDao.getListMaxProduct();
	}
	public List<Product> getListAllProduct(){
		return userDao.getListAllProduct();
	}
	
	public List<Product> getListNAllProduct(int pageNumber,int pageSize){
		return userDao.getListNAllProduct(pageNumber, pageSize);
	}
	
	public Product getOneProduct(int id){
		return userDao.getOneProduct(id);
	}
	
	public void addOrders(Orders orders){
		userDao.addOrders(orders);
	}
	
	public void updateProduct(int id){
		userDao.updateProduct(id);
	}
	
	public List<Orders> getListNAllOrder(int pageNumber,int pageSize,User user){
		return userDao.getListNAllOrder(pageNumber, pageSize, user);
	}
	
	public List<Orders> getListNAllOrder(User user){
		return userDao.getListNAllOrder(user);
	}
	public User validate(String email, String passwd){
		return userDao.validate(email, passwd);
	}
	public User getUser(String email){	
		return userDao.getUser(email);
	}
	
	public List<Productsort> getListProductsort(){
		return userDao.getListProductsort();
	}
	
	public List<Product> getListNAllProduct(int pageNumber,int pageSize,Productsort productsort,float price1, float price2, String name){
		return userDao.getListNAllProduct(pageNumber, pageSize, productsort, price1, price2, name);
	}
}
