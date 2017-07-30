package com.phoneWeb.utils;

import java.util.List;

import com.phoneWeb.entities.Admin;
import com.phoneWeb.entities.Guestbook;
import com.phoneWeb.entities.News;
import com.phoneWeb.entities.Product;

public class JsonUtils {
	/*
	 * 获得管理员信息的json数据
	 */
	public static String getAdminJson(List<Admin> list) {
		String json = "[";
		for (Admin admin : list) {
			json += "{\"aname\":\"" + admin.getAdminname() + "\",\"name\":\""
					+ admin.getName() + "\",\"atype\":\""
					+ admin.getType() + "\"},";
		}
		json = json.substring(0, json.length() - 1);
		json += "]";
		return json;
	}
	
	/*
	 * 获得新闻列表信息
	 */
	public static String getNewsJson(List<News> list, int pageNumber,
			int pageSize) {
		String json = "";
		int total = 0;// 记录总数
		total = list.size();
		json += "{\"total\":\"" + total + "\",\"rows\":[";
		int totals = (pageNumber * pageSize) <= total ? (pageNumber * pageSize)
				: total;
		int i = (pageNumber - 1) * pageSize;
		for (int j = i; j < totals; j++) {
			News news=list.get(j);
			json += "{\"nid\":\"" + news.getId() + "\",\"ntitle\":\""
					+ stringtoJson(news.getTitle()) + "\"},";
		}
		json = json.substring(0, json.length() - 1);
		json += "]}";
		return json;
	}
	/*
	 * 获得留言列表信息
	 */
	public static String getGbookJson(List<Guestbook> list, int pageNumber,
			int pageSize) {
		String json = "";
		int total = 0;// 记录总数
		total = list.size();
		json += "{\"total\":\"" + total + "\",\"rows\":[";
		int totals = (pageNumber * pageSize) <= total ? (pageNumber * pageSize)
				: total;
		int i = (pageNumber - 1) * pageSize;
		for (int j = i; j < totals; j++) {
			Guestbook guestbook =list.get(j);
			json += "{\"gid\":\"" + guestbook.getId() + "\",\"gtitle\":\""
					+ stringtoJson(guestbook.getTitle()) + "\"},";
		}
		json = json.substring(0, json.length() - 1);
		json += "]}";
		return json;
	}
	
	/*
	 * 获得产品列表信息
	 */
	public static String getProductJson(List<Product> list, int pageNumber,
			int pageSize) {
		String json = "";
		int total = 0;// 记录总数
		total = list.size();
		json += "{\"total\":\"" + total + "\",\"rows\":[";
		int totals = (pageNumber * pageSize) <= total ? (pageNumber * pageSize)
				: total;
		int i = (pageNumber - 1) * pageSize;
		for (int j = i; j < totals; j++) {
			Product product =list.get(j);
			json += "{\"pid\":\"" + product.getId() + "\",\"pname\":\""
					+ stringtoJson(product.getPhonename()) + "\"},";
		}
		json = json.substring(0, json.length() - 1);
		json += "]}";
		return json;
	}
	
	/** 
     * JSON字符串特殊字符处理，比如：“\A1;1300” 
     * @param s 
     * @return String 
     */  
    public static String stringtoJson(String s) {        
        StringBuffer sb = new StringBuffer();        
        for (int i=0; i<s.length(); i++) {  
            char c = s.charAt(i);    
             switch (c){  
//             case '\"':        
//                 sb.append("\\\"");        
//                 break;   
             case '"':
            	 sb.append("'");break;
//             case '\\':        
//                 sb.append("\\\\");        
//                 break;        
//             case '/':        
//                 sb.append("\\/");        
//                 break;        
//             case '\b':        
//                 sb.append("\\b");        
//                 break;        
//             case '\f':        
//                 sb.append("\\f");        
//                 break;        
//             case '\n':        
//                 sb.append("\\n");        
//                 break;        
//             case '\r':        
//                 sb.append("\\r");        
//                 break;        
//             case '\t':        
//                 sb.append("\\t");        
//                 break;        
             default:        
                 sb.append(c);     
             }  
         }      
        return sb.toString();     
        }  
	
}
