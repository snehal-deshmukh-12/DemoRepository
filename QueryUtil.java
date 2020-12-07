package com.springboot.namedquery;

public class QueryUtil {


	public String createQueryForNames(String name, String description) {
		String str= "Select t from Topic t where t.name ='"+name+"' and t.description ='"+description+"'";
		
		return str;
	}

}
