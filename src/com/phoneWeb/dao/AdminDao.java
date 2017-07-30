package com.phoneWeb.dao;

import java.util.List;

import org.hibernate.Query;

import com.phoneWeb.entities.Admin;
import com.phoneWeb.entities.Guestbook;
import com.phoneWeb.entities.News;
import com.phoneWeb.entities.Product;
import com.phoneWeb.entities.Productsort;

public class AdminDao extends BaseDao {
	public Admin validate(String adminname, String passwd) {
		String hql = "from Admin a where a.adminname = ? and a.passwd= ?";
		Query query = getSession().createQuery(hql).setString(0, adminname)
				.setString(1, passwd);
		getSession().close();
		return (Admin) query.uniqueResult();
	}

	public Admin getAdmin(String adminname) {
		String hql = "from Admin a where a.adminname = ?";
		Query query = getSession().createQuery(hql).setString(0, adminname);
		return (Admin) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmins() {
		String hql = "from Admin a where a.type != ?";
		return getSession().createQuery(hql).setString(0, "0").list();
	}

	public void AddAdmin(Admin admin) {
		getSession().saveOrUpdate(admin);
		getSession().close();
	}

	public int DelAdmin(int id) {
		String hql = "delete from Admin a where a.id = ?";
		return getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}

	public int editAdmin(Admin admin) {
		String hql = "update Admin a set a.adminname = ?,a.name=?,a.type=? where a.id=?";
		return getSession().createQuery(hql).setString(0, admin.getAdminname())
				.setString(1, admin.getName()).setString(2, admin.getType())
				.setInteger(3, admin.getId()).executeUpdate();
	}

	public int reloadPaawd(String adminname,String passwd){
		String hql = "update Admin a set a.passwd = ? where a.adminname=?";
		return getSession().createQuery(hql).setString(0, passwd)
				.setString(1, adminname).executeUpdate();
	}
	public void AddNews(News news){
		getSession().saveOrUpdate(news);
	}
	
	@SuppressWarnings("unchecked")
	public List<News> getListNews(){
		String hql = "from News n order by n.newsdate desc";
		return getSession().createQuery(hql).list();
	}
	
	
	
	public int delNews(int id){
		String hql = "delete from News n where n.id = ?";		
		return getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	@SuppressWarnings("unchecked")
	public List<Guestbook> getListGbook(){
		String hql = "from Guestbook g order by g.createdate desc";
		return getSession().createQuery(hql).list();
	}
	
	public int delGbook(int id){
		String hql = "delete from Guestbook g where g.id = ?";		
		return getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public Guestbook getGuestbook(int id){
		String hql = "from Guestbook g where g.id = ?";
		Query query = getSession().createQuery(hql).setInteger(0, id);
		getSession().close();
		return (Guestbook)query.uniqueResult();
	}
	
	public void addProductsort(Productsort productsort){
		getSession().saveOrUpdate(productsort);
		getSession().close();
	}
	
	public void addProduct(Product product){
		getSession().saveOrUpdate(product);
		getSession().close();
	}
	@SuppressWarnings("unchecked")
	public List<Productsort> getListProductsort(){
		String hql = "from Productsort p";
		return getSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> getListProduct(){
		String hql = "from Product p order by p.ccdate desc";
		return getSession().createQuery(hql).list();
	}
	
	public int delphone(int id){
		String hql = "delete from Product p where p.id = ?";		
		return getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public Product getOneProduct(int id){
		String hql = "from Product p where p.id = ?";
		Query query = getSession().createQuery(hql).setInteger(0, id);
		getSession().close();
		return (Product)query.uniqueResult();
	}
	
}
