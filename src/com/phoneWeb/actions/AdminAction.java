package com.phoneWeb.actions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.phoneWeb.entities.Admin;
import com.phoneWeb.entities.Guestbook;
import com.phoneWeb.entities.News;
import com.phoneWeb.entities.Product;
import com.phoneWeb.entities.Productsort;
import com.phoneWeb.service.AdminService;
import com.phoneWeb.utils.DeleteFileUtils;
import com.phoneWeb.utils.JsonUtils;
import com.phoneWeb.utils.Md5Utils;
import com.phoneWeb.utils.UploadUtils;

/**
 * 程序是处理关于管理员登陆后的一些操作请求的
 */

public class AdminAction extends ActionSupport implements SessionAware,
		RequestAware {

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private Map<String, Object> request;
	private AdminService adminService;
	private Admin admin;
	private String code;
	private InputStream inStream;
	private String type;
	private News news;
	private Guestbook guestbook;
	private Productsort productsort;
	private Product product;

	private File picture; // 图片
	private String pictureFileName;// 图片名称
	private String pictureContentType; // 文件类型

	private Integer page; // 新闻的页数
	private Integer rows; // 新闻每页的条数

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public File getPicture() {
		return picture;
	}

	public void setPictureFileName(String pictureFileName) {
		this.pictureFileName = pictureFileName;
	}

	public String getPictureFileName() {
		return pictureFileName;
	}

	public void setPictureContentType(String pictureContentType) {
		this.pictureContentType = pictureContentType;
	}

	public String getPictureContentType() {
		return pictureContentType;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public void setType(String type) {
		this.type = type;
	}

	public InputStream getInStream() {
		return inStream;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Admin getAdmin() {
		return admin;
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

	public void setGuestbook(Guestbook guestbook) {
		this.guestbook = guestbook;
	}

	public Guestbook getGuestbook() {
		return guestbook;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public News getNews() {
		return news;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	// 管理员请求登陆
	public String alogin() {
		return "alogin";
	}

	// 登陆成功
	public String dologin() {
		return SUCCESS;
	}

	// 判断是否是合法管理员
	public void validateDologin() {
		// System.out.println(admin.getAdminname()+","+admin.getPasswd()+","+code);
		Admin a_admin = adminService.validateDologin(admin.getAdminname(),
				Md5Utils.md5(admin.getPasswd()));
		String r_code = session.get("rand").toString();
		if (!r_code.equals(code)) {
			addFieldError("code", "验证码错误!");
		} else if (a_admin == null) {
			addFieldError("admin.passwd", "用户名或密码错误!");
			return;
		} else {
			session.put("admin", a_admin);
		}
	}

	// 请求到管理员管理员管理界面
	public String solve() {
		return "solve";
	}

	// 请求管理员的数据(json)
	public String dosolve() {
		String result = JsonUtils.getAdminJson(adminService.getAllAdmins());
		try {
			inStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "ajax-success";
	}

	// 处理添加管理员的请求
	public String addadmin() {
		if (type.equals("0")) {
			admin.setPasswd(Md5Utils.md5("123456"));
			if (adminService.checkAdmin(admin.getAdminname()) == null) {
				adminService.Addadmin(admin);
				try {
					inStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					inStream = new ByteArrayInputStream("2".getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if (type.equals("1")) {
			Admin a_admin = adminService.checkAdmin(admin.getAdminname());
			a_admin.setName(admin.getName());
			a_admin.setType(admin.getType());
			adminService.editAdmin(a_admin);
			try {
				inStream = new ByteArrayInputStream("3".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return "ajax-success";
	}

	// 处理删除管理员的请求
	public String deladmin() {
		Admin a_admin = adminService.checkAdmin(admin.getAdminname());
		if (adminService.Deladmin(a_admin.getId()) != 0) {
			try {
				inStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				inStream = new ByteArrayInputStream("2".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "ajax-success";
	}

	// 处理重置密码 的请求、
	public String reloadpasswd() {
		adminService.reloadPasswd(admin.getAdminname(), Md5Utils.md5("123456"));
		try {
			inStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ajax-success";
	}

	/*
	 * 管理员请求管理新闻
	 */
	public String newsmanage() {
		return "newsmanage";
	}

	/*
	 * 管理员请求发布新闻
	 */
	public String newsrelease() {
		return "newsrelease";
	}

	/*
	 * 管理员添加新闻到数据库
	 */
	public String addnews() {
		news.setNewsdate(new Date());
		adminService.AddNews(news);
		request.put("addsuccess", "添加成功!");
		return "newsrelease";
	}

	/*
	 * 管理员获得管理新闻列表
	 */
	public String donewsmanage() {
		String result = JsonUtils.getNewsJson(adminService.getListNews(), page,
				rows);
		try {
			inStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "ajax-success";
	}

	/*
	 * 处理删除新闻的请求
	 */
	public String delnews() {
		if (adminService.delNews(news.getId()) != 0) {// 删除成功
			try {
				inStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {// 删除失败
			try {
				inStream = new ByteArrayInputStream("2".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "ajax-success";
	}

	/*
	 * 管理员请求管理新闻
	 */
	public String gbookmanage() {
		return "gbookmanage";
	}

	/*
	 * 管理员获得管理留言列表
	 */
	public String dogbookmanage() {
		String result = JsonUtils.getGbookJson(adminService.getListGbook(),
				page, rows);
		try {
			inStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "ajax-success";
	}

	/*
	 * 管理员删除某条留言
	 */
	public String delgbook() {
		if (adminService.delGbook(guestbook.getId()) != 0) {// 留言删除成功
			try {
				inStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} else {// 留言删除失败
			try {
				inStream = new ByteArrayInputStream("2".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		return "ajax-success";
	}

	/*
	 * 管理员删除某条留言
	 */
	public String gbookck() {
		guestbook = adminService.getGuestbook(guestbook.getId());
		return "gbdetail";
	}

	/*
	 * 管理员请求上传手机详细信息界面
	 */
	public String uploadphone() {
		request.put("productsorts", adminService.getListProductsort());
		return "uploadphone";
	}

	/*
	 * 管理员请求上传手机种类界面
	 */
	public String uploadphonetype() {
		return "uploadphonetype";
	}

	/*
	 * 管理员添加手机种类
	 */
	public String addphonetype() {
		adminService.addProductsort(productsort);
		request.put("addphonetypesuccess", "添加成功!");
		return "uploadphonetype";
	}

	/*
	 * 管理员添加手机种类
	 */
	public String addphone() {
		request.put("productsorts", adminService.getListProductsort());
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/phoneimg");
		realPath += "\\";
		pictureFileName = UploadUtils.generateRandonFileName(pictureFileName);
		if (picture != null) {//图片不能为空
			if (pictureContentType.equals("image/jpeg")
					|| pictureContentType.equals("image/bmp")
					|| pictureContentType.equals("image/x-png")
					|| pictureContentType.equals("image/gif")) {//检验图片格式
				File saveFile = new File(new File(realPath),pictureFileName);
				if (!saveFile.getParentFile().exists()) {
					saveFile.getParentFile().mkdirs();
				}

				realPath += pictureFileName;
				try {
					FileUtils.copyFile(picture, saveFile);
					// 把图片写入到上面设置的路径里
					// OutputStream os = new FileOutputStream(realPath);
					// byte[] buffer = new byte[400];
					// int length = 0 ;
					// while((length = inStream.read(buffer))>0){
					// os.write(buffer, 0, length);
					// }
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				product.setPhonebigimg(pictureFileName);
				product.setProductsort(productsort);
				product.setCcdate(new Date());
				adminService.addProduct(product);
				request.put("addphonesuccess", "添加成功!");	
			} else {
				request.put("imgerror", "图片类型错误，请选择jpg、gif、bmp或png！");
			}
		}else{
			request.put("addphonesuccess", "请上传图片!");
		}
		return "uploadphone";
	}

	// public String upload(){
	//
	// String realPath =
	// ServletActionContext.getServletContext().getRealPath("/phoneimg");
	// if(img != null){
	// if(!(imgContentType.equals("jpg")) || !(imgContentType.equals("gif")) ||
	// !(imgContentType.equals("png"))){
	// request.put("imgerror", "图片类型错误，请选择jpg、gif或png！");
	// }else{
	// File saveFile = new File(new
	// File(realPath),UploadUtils.generateRandonFileName(imgFilename));
	// if(!saveFile.getParentFile().exists()){
	// saveFile.getParentFile().mkdirs();
	// }
	// realPath += UploadUtils.generateRandonFileName(imgFilename);
	// try {
	// FileUtils.copyFile(img, saveFile);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// return realPath;
	// }
	// return null;
	// }dophonemanage
	
	
	/*
	 * 管理员请求管理产品
	 */
	public String phonemanage() {
		return "phonemanage";
	}
	
	/*
	 * 管理员请求管理产品的json数据
	 */
	public String dophonemanage(){
		String result = JsonUtils.getProductJson(adminService.getListProduct(), page,
				rows);
		try {
			inStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "ajax-success";
	}
	
	public String delphone() {
		String realPath = ServletActionContext.getServletContext().getRealPath(
				"/phoneimg");
		product = adminService.getOneProduct(product.getId());
		realPath += "/" + product.getPhonebigimg();
		if (adminService.delphone(product.getId()) != 0) {// 删除成功
			DeleteFileUtils.delete(realPath);
			try {
				inStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {// 删除失败
			try {
				inStream = new ByteArrayInputStream("2".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "ajax-success";
	}
}
