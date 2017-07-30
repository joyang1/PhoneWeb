package com.phoneWeb.dao;

import java.util.List;

import org.hibernate.Query;

import com.phoneWeb.entities.Admin;
import com.phoneWeb.entities.Guestbook;
import com.phoneWeb.entities.News;
import com.phoneWeb.entities.Orders;
import com.phoneWeb.entities.Product;
import com.phoneWeb.entities.Productsort;
import com.phoneWeb.entities.User;

public class UserDao extends BaseDao {
	public void AddUser(User user){
		getSession().saveOrUpdate(user);
		getSession().close();
	}
	
	public User validate(String email, String passwd) {
//		String hql = "from User u where u.email = ? and u.passwd= ? and u.isactive = ?";
//		Query query = getSession().createQuery(hql).setString(0, email)
//				.setString(1, passwd).setString(2, "1");
		String hql = "from User u where u.email = ? and u.passwd= ?";
		Query query = getSession().createQuery(hql).setString(0, email)
				.setString(1, passwd);
		getSession().close();
		return (User) query.uniqueResult();
	}

	public void jihuo(String email){
		String hql = "update User u set u.isactive = ? where u.email = ?";
		getSession().createQuery(hql).setString(0, "1").setString(1, email).executeUpdate();
		getSession().close();
	}
	
	public User getUser(String email) {
		String hql = "from User u where u.email = ?";
		Query query = getSession().createQuery(hql).setString(0, email);
		return (User) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<News> getListNNews(){
		String hql = "from News n order by n.newsdate desc";
		Query query = getSession().createQuery(hql);
		query.setMaxResults(13);
		getSession().close();
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public List<News> getListNNews(int pageNumber,int pageSize){
		String hql = "from News n order by n.newsdate desc";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((pageNumber-1)*pageSize).setMaxResults(pageSize);
		getSession().close();
		return query.list();
	}
	public News getOneNews(int id){
		String hql = "from News n where n.id = ?";
		Query query = getSession().createQuery(hql).setInteger(0, id);
		getSession().close();
		return (News)query.uniqueResult();
	}
	public News getOneNews(){
		String hql = "from News n order by n.newsdate desc";
		Query query = getSession().createQuery(hql).setMaxResults(1);
		getSession().close();
		return (News)query.uniqueResult();
	}
	public void addGuessbook(Guestbook guestbook){
		getSession().saveOrUpdate(guestbook);
		getSession().close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getListFProduct(){
		String hql = "from Product p order by p.ccdate desc";
		Query query = getSession().createQuery(hql).setMaxResults(4);
		getSession().close();
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getListRXProduct(){
		String hql = "from Product p order by p.buynum desc";
		Query query = getSession().createQuery(hql).setMaxResults(3);
		getSession().close();
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public List<Product> getListMaxProduct(){
		String hql = "from Product p order by p.buynum desc";
		Query query = getSession().createQuery(hql).setMaxResults(10);
		getSession().close();
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getListAllProduct(){
		String hql = "from Product p order by p.ccdate desc";
		Query query = getSession().createQuery(hql);
		getSession().close();
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getListNAllProduct(int pageNumber,int pageSize){
		String hql = "from Product p order by p.ccdate desc";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((pageNumber-1)*pageSize).setMaxResults(pageSize);
		getSession().close();
		return query.list();
	}
	
	public Product getOneProduct(int id){
		String hql = "from Product p where p.id = ?";
		Query query = getSession().createQuery(hql).setInteger(0, id);
		getSession().close();
		return (Product)query.uniqueResult();
	}
	
	public void addOrders(Orders orders){
		getSession().saveOrUpdate(orders);
		getSession().close();
	}
	
	public void updateProduct(int id){
		Product product = getOneProduct(id);
		String hql = "update Product p set p.buynum = ? where p.id = ?";
		getSession().createQuery(hql).setInteger(0, product.getBuynum()+1).setInteger(1, id).executeUpdate();
		getSession().close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Orders> getListNAllOrder(int pageNumber,int pageSize,User user){
		String hql = "from Orders o where o.user = ? order by o.createdate desc";
		Query query = getSession().createQuery(hql).setEntity(0, user);
		query.setFirstResult((pageNumber-1)*pageSize).setMaxResults(pageSize);
		getSession().close();
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Orders> getListNAllOrder(User user){
		String hql = "from Orders o where o.user = ? order by o.createdate desc";
		Query query = getSession().createQuery(hql).setEntity(0, user);
		getSession().close();
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Productsort> getListProductsort(){
		String hql = "from Productsort p";
		return getSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getListNAllProduct(int pageNumber,int pageSize,Productsort productsort,float price1, float price2, String name){
		String hql = "from Product p where p.productsort = ? and p.price >= ? and p.price <= ? and p.phonename like :name order by p.ccdate desc";
		Query query = getSession().createQuery(hql).setEntity(0, productsort).setFloat(1, price1).setFloat(2, price2).setString("name", "%"+name+"%");
		query.setFirstResult((pageNumber-1)*pageSize).setMaxResults(pageSize);
		getSession().close();
		return query.list();
	}
}
