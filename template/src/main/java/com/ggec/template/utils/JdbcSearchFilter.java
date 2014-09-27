package com.ggec.template.utils;

/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang3.StringUtils;
import com.google.common.collect.Maps;

public class JdbcSearchFilter {

	public enum Operator {
		EQ, LIKE, GT, LT, GTE, LTE
	}

	public String fieldName;
	public Object value;
	public Operator operator;

	public JdbcSearchFilter(String fieldName, Object value) {
		this.fieldName = fieldName;
		this.value = value;
	}

	/**
	 * searchParams中key的格式为OPERATOR_FIELDNAME
	 */
	public static Map<String, Object> parse(Map<String, Object> searchParams) {
		Map<String,Object> filters = Maps.newHashMap();

		for (Entry<String, Object> entry : searchParams.entrySet()) {
			// 过滤掉空值
			String key = entry.getKey();
			Object value = entry.getValue();
			if (StringUtils.isBlank((String) value)) {
				continue;
			}

			// 拆分operator与filedAttribute
			String[] names = StringUtils.split(key, "_");
			if (names.length != 2) {
				throw new IllegalArgumentException(key + " is not a valid search filter name");
			}
			String fieldName = names[1];
		    String tableFieldName=toTableField(fieldName); //转换成数据库字段
			Operator operator = Operator.valueOf(names[0]);         
			// 创建searchFilter
			if(operator==Operator.LIKE) value="%"+value+"%";
			filters.put(tableFieldName, value);
		}

		return filters;
	}
	
   //按照大写字母进行转换
	static String toTableField(String fieldName){
       
	   StringBuilder sb =new StringBuilder();
	   int startIndex=0;
	   char[] chars =  fieldName.toCharArray();	
	   for(int i=0;i<chars.length;i++){
		   
	       if(Character.isUpperCase(chars[i])){
	    	 sb.append(fieldName.substring(startIndex, i)+"_");
	    	 Character.toLowerCase(chars[i]);
	         startIndex=i;
	       }
	       
	       if(i==chars.length-1){
	    	   sb.append(fieldName.substring(startIndex, chars.length).toLowerCase());
	       }
	      
	    }
		return sb.toString();
	}
	
	
	
}
