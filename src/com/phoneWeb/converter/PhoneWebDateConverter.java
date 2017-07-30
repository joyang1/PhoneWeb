package com.phoneWeb.converter;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class PhoneWebDateConverter extends StrutsTypeConverter {
	
	private DateFormat dateFormat;
	{
		dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	}
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		if(arg2 == Date.class){
			try {
				return dateFormat.parse(arg1[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		if(arg1 instanceof Date){
			return dateFormat.format((Date)arg1);
		}
		return null;
	}

}
