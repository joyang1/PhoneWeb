package com.phoneWeb.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.phoneWeb.entities.Guestbook;
import com.phoneWeb.entities.News;
import com.phoneWeb.entities.Orders;
import com.phoneWeb.entities.Product;
import com.phoneWeb.entities.Productsort;
import com.phoneWeb.entities.User;
import com.phoneWeb.service.UserService;
import com.phoneWeb.utils.MailUtils;
import com.phoneWeb.utils.Md5Utils;
import com.sun.corba.se.pept.transport.ContactInfo;

public class UserAction extends ActionSupport implements RequestAware,
		SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private User user;
	private News news;
	private Product product;
	private Productsort productsort;
	private Guestbook guestbook;
	private List<News> listnews; // 新闻列表集合
	private List<Product> listproduct; // 产品列表集合
	private List<Product> listproduct1; // 产品列表集合1
	private List<Product> listproduct2; // 产品列表集合2
	private List<Orders> listorder; // 交易列表集合
	private List<Productsort> listproductsort; // 产品列表集合

	private float sprice1;
	private float sprice2;

	private int newstotal; // 新闻总条数
	private int newspages; // 新闻页数
	private int newspageSize = 10; // 每页显示新闻的条数
	private int newspageNumber = 1; // 当前显示的页数

	private Orders orders;

	private int phonetotal; // 产品总条数
	private int phonepages; // 产品页数
	private int phonepageSize = 20; // 每页显示产品的条数
	private int phonepageNumber = 1; // 当前显示的页数

	private int gettotal; // 购买产品总条数
	private int getpages; // 购买产品页数
	private int getpageSize = 10; // 每页显示购买产品的条数
	private int getpageNumber = 1; // 当前显示的页数

	private InputStream inStream;

	private Map<String, Object> session;
	private Map<String, Object> request;
	
	private String ly;
	
	public void setLy(String ly) {
		this.ly = ly;
	}
	public String getLy() {
		return ly;
	}
	

	public void setSprice1(float sprice1) {
		this.sprice1 = sprice1;
	}

	public float getSprice1() {
		return sprice1;
	}

	public void setSprice2(float sprice2) {
		this.sprice2 = sprice2;
	}

	public float getSprice2() {
		return sprice2;
	}

	public InputStream getInStream() {
		return this.inStream;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProductsort(Productsort productsort) {
		this.productsort = productsort;
	}

	public Productsort getProductsort() {
		return productsort;
	}

	public void setListorder(List<Orders> listorder) {
		this.listorder = listorder;
	}

	public List<Orders> getListorder() {
		return listorder;
	}

	public void setNewspageNumber(int newspageNumber) {
		this.newspageNumber = newspageNumber;
	}

	public void setGettotal(int gettotal) {
		this.gettotal = gettotal;
	}

	public int getGettotal() {
		return gettotal;
	}

	public void setGetpages(int getpages) {
		this.getpages = getpages;
	}

	public int getGetpages() {
		return getpages;
	}

	public void setGetpageNumber(int getpageNumber) {
		this.getpageNumber = getpageNumber;
	}

	public int getGetpageNumber() {
		return getpageNumber;
	}

	public void setGetpageSize(int getpageSize) {
		this.getpageSize = getpageSize;
	}

	public int getGetpageSize() {
		return getpageSize;
	}

	public int getNewspageNumber() {
		return newspageNumber;
	}

	public void setNewspageSize(int newspageSize) {
		this.newspageSize = newspageSize;
	}

	public int getNewspageSize() {
		return newspageSize;
	}

	public void setNewstotal(int newstotal) {
		this.newstotal = newstotal;
	}

	public int getNewstotal() {
		return newstotal;
	}

	public void setNewspages(int newspages) {
		this.newspages = newspages;
	}

	public int getNewspages() {
		return newspages;
	}

	public void setPhonetotal(int phonetotal) {
		this.phonetotal = phonetotal;
	}

	public int getPhonetotal() {
		return phonetotal;
	}

	public void setPhonepages(int phonepages) {
		this.phonepages = phonepages;
	}

	public int getPhonepages() {
		return phonepages;
	}

	public void setPhonepageSize(int phonepageSize) {
		this.phonepageSize = phonepageSize;
	}

	public int getPhonepageSize() {
		return phonepageSize;
	}

	public void setPhonepageNumber(int phonepageNumber) {
		this.phonepageNumber = phonepageNumber;
	}

	public int getPhonepageNumber() {
		return phonepageNumber;
	}

	public void setListnews(List<News> listnews) {
		this.listnews = listnews;
	}

	public List<News> getListnews() {
		return listnews;
	}

	public void setListproduct(List<Product> listproduct) {
		this.listproduct = listproduct;
	}

	public List<Product> getListproduct() {
		return listproduct;
	}

	public void setListproduct1(List<Product> listproduct1) {
		this.listproduct1 = listproduct1;
	}

	public List<Product> getListproduct1() {
		return listproduct1;
	}

	public void setListproduct2(List<Product> listproduct2) {
		this.listproduct2 = listproduct2;
	}

	public List<Product> getListproduct2() {
		return listproduct2;
	}

	public void setListproductsort(List<Productsort> listproductsort) {
		this.listproductsort = listproductsort;
	}

	public List<Productsort> getListproductsort() {
		return listproductsort;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public void setGuestbook(Guestbook guestbook) {
		this.guestbook = guestbook;
	}

	public Guestbook getGuestbook() {
		return guestbook;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public News getNews() {
		return news;
	}

	/*
	 * 首页数据处理
	 */
	public String indexsovle() {
		listproductsort = userService.getListProductsort();
		listproduct1 = userService.getListRXProduct();
		listproduct2 = userService.getListMaxProduct();
		listproduct = userService.getListFProduct();
		listnews = userService.getListNNews();
		return "phoneweb";
	}

	/*
	 * 处理注册界面的请求
	 */
	public String reg() {
		return "reg";
	}

	/*
	 * 处理用户激活的请求
	 */
	public String jihuo() {
		userService.jihuo(user.getEmail());
		user = userService.getUser(user.getEmail());
		session.put("user", user);
		listproductsort = userService.getListProductsort();
		listproduct1 = userService.getListRXProduct();
		listproduct2 = userService.getListMaxProduct();
		listproduct = userService.getListFProduct();
		listnews = userService.getListNNews();
		return "phoneweb";
	}
	
	/*
	 * 处理登陆界面的请求
	 */
	public String login() {
		if(ly == null){
			request.put("loginfirst", "");
		}else{
			request.put("loginfirst", "请先登陆才能购买,谢谢!");
		}
		return "login";
	}

	/*
	 * 处理退出网站的请求
	 */
	public String loginout() {
		session.clear();
		listproductsort = userService.getListProductsort();
		listproduct1 = userService.getListRXProduct();
		listproduct2 = userService.getListMaxProduct();
		listproduct = userService.getListFProduct();
		listnews = userService.getListNNews();
		return "phoneweb";
	}

	/*
	 * 处理登陆的请求
	 */
	public String dologin() {
		if (userService.validate(user.getEmail(),
				Md5Utils.md5(user.getPasswd())) != null) {
			session.put("user", userService.getUser(user.getEmail()));
			listproductsort = userService.getListProductsort();
			listproduct1 = userService.getListRXProduct();
			listproduct2 = userService.getListMaxProduct();
			listproduct = userService.getListFProduct();
			listnews = userService.getListNNews();
			return "phoneweb";
		} else if(userService.getUser(user.getEmail()).getIsactive().equals("0")){
			request.put("loginerror", "未激活,请登录邮箱激活!");
			return "login";
		}else {
			request.put("loginerror", "登陆失败,用户名或密码错误!");
			return "login";
		}

	}

	/*
	 * 处理用户注册提交过来的数据 成功跳到登陆界面
	 */
	public String regedit() {
		user.setIsactive("0");// 第一步注册，但是未激活
		user.setPasswd(Md5Utils.md5(user.getPasswd()));
		userService.AddUser(user);
		try {
			MailUtils
					.sendMail("phoneWeb用户激活", user.getEmail(),
							"这是一封激活邮件，请<a href='http://59.46.168.82:9090/PhoneWeb/user-jihuo?user.email='\""+user.getEmail()+"\">点击激活</a>");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "regSuccess";
	}

	/*
	 * 处理新闻内容页的请求
	 */
	public String newscontent() {
		news = userService.getOneNews(news.getId());
		if (news == null) {
			news = userService.getOneNews();
		}
		return "newscontent";
	}

	/*
	 * 处理新闻列表页的请求
	 */
	public String newslist() {
		newstotal = userService.getListNNews().size();
		// 防止恶意攻击网站者
		if (newspageSize < 16) {
			newspageSize = 10;
		} else if (newspageSize >= 16 && newspageSize < 36) {
			newspages = 20;
		} else {
			newspageSize = 50;
		}
		newspages = newstotal / newspageSize + 1;
		// 防止恶意攻击网站者
		if (newspageNumber > newspages) {
			newspageNumber = newspages;
		} else if (newspageNumber < 1) {
			newspageNumber = 1;
		}

		listnews = userService.getListNNews(newspageNumber, newspageSize);
		return "newslist";
	}

	/*
	 * 处理联系我们的请求
	 */
	public String contact() {
		return "contact";
	}

	/*
	 * 处理关于系统的请求
	 */
	public String about() {
		return "about";
	}

	/*
	 * 处理关于留言模块界面的请求
	 */
	public String guestbook() {
		return "guestbook";
	}

	/*
	 * 处理添加留言的请求
	 */
	public String addguestbook() {
		Guestbook gb = new Guestbook();
		gb.setEmail("joyang1993@sina.com");
		// guestbook.setUser(user);
		gb.setCreatedate(new Date());
		gb.setTitle(guestbook.getTitle());
		gb.setContent(guestbook.getContent());
		userService.addGuessbook(gb);
		request.put("addguestbook", "留言完成!");
		return "guestbooksuccess";
	}

	/*
	 * 处理关于留言模块界面的请求
	 */
	public String phonelist() {
		phonetotal = userService.getListAllProduct().size();
		// 防止恶意攻击网站者
		if (phonepageSize < 26) {
			phonepageSize = 20;
		} else if (phonepageSize >= 26 && phonepageSize < 40) {
			phonepages = 32;
		} else {
			phonepageSize = 48;
		}
		phonepages = phonetotal / phonepageSize + 1;
		// 防止恶意攻击网站者
		if (phonepageNumber > phonepages) {
			phonepageNumber = phonepages;
		} else if (phonepageNumber < 1) {
			phonepageNumber = 1;
		}

		listproduct = userService.getListNAllProduct(phonepageNumber,
				phonepageSize);
		return "phonelist";
	}

	/*
	 * 处理关于留言模块界面的请求
	 */
	public String getlist() {
		user = (User) session.get("user");
		if (user != null) {
			gettotal = userService.getListNAllOrder(user).size();
			// 防止恶意攻击网站者
			if (getpageSize < 16) {
				getpageSize = 10;
			} else if (phonepageSize >= 16 && phonepageSize < 26) {
				getpages = 20;
			} else {
				getpageSize = 30;
			}
			getpages = gettotal / getpageSize + 1;
			// 防止恶意攻击网站者
			if (getpageNumber > getpages) {
				getpageNumber = getpages;
			} else if (getpageNumber < 1) {
				getpageNumber = 1;
			}

			listorder = userService.getListNAllOrder(getpageNumber,
					getpageSize, user);
			return "getlist";
		} else {
			request.put("loginfirst", "请先登陆才能购买,谢谢!");
			return "login";
		}

	}

	/*
	 * 处理关于到手机购买详细页的请求
	 */
	public String phonedetail() {
		product = userService.getOneProduct(product.getId());
		// request.put("getsuccess", "");
		return "phonedetail";
	}

	/*
	 * 处理关于到购买手机的请求
	 */
	public String getphone() {
		user = (User) session.get("user");
		if (user != null) {
			orders = new Orders();
			orders.setCreatedate(new Date());
			orders.setPhone(product);
			orders.setUser(user);
			orders.setEmail(user.getEmail());
			// request.put("getsuccess", "购买成功!进入注册邮箱查看详细信息!");
			try {
				MailUtils.sendMail("phoneWeb购买提示", user.getEmail(),
						"谢谢购买phoneWeb的产品!\n你购买的是" + product.getPhonename()
								+ ";\n价格是" + product.getPrice() + "。");
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			userService.updateProduct(product.getId());
			userService.addOrders(orders);

			try {
				inStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			//request.put("loginfirst", "请先登陆才能购买,谢谢!");
			try {
				inStream = new ByteArrayInputStream("3".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "ajax-success";
	}

	/*
	 * 处理联系我们的请求
	 */
	public String search() {
		phonetotal = userService.getListNAllProduct(phonepageNumber,
				phonepageSize, productsort, sprice1, sprice2,
				product.getPhonename()).size();
		// 防止恶意攻击网站者
		if (phonepageSize < 26) {
			phonepageSize = 20;
		} else if (phonepageSize >= 26 && phonepageSize < 40) {
			phonepages = 32;
		} else {
			phonepageSize = 48;
		}
		phonepages = phonetotal / phonepageSize + 1;
		// 防止恶意攻击网站者
		if (phonepageNumber > phonepages) {
			phonepageNumber = phonepages;
		} else if (phonepageNumber < 1) {
			phonepageNumber = 1;
		}

		listproduct = userService.getListNAllProduct(phonepageNumber,
				phonepageSize, productsort, sprice1, sprice2,
				product.getPhonename());

		return "phonelist";
	}

}
