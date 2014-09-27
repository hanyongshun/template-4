package com.ggec.template.utils;

import java.io.Serializable;
import java.util.List;

public class JdbcPage<T> implements Serializable {

	private static final long serialVersionUID=1L;

	
	private int number; // pagenumber
	private int size; //pagesize
	private List<T> content; //content
	private String sort; //
	private int totalPages;

	
	public JdbcPage(List<T> list,int pageNumber,int pageSize,String sort,int totalPages){
	
		this.content = list;
		this.number = pageNumber;
		this.size = pageSize;
		this.sort = sort;
		this.totalPages = totalPages;
	}
	
	
	public int getNumber() {
		// TODO Auto-generated method stub
		return number;
	}

	
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	
	public List<T> getContent() {
		// TODO Auto-generated method stub
		return content;
	}

	
	public boolean hasContent() {
		// TODO Auto-generated method stub
		return this.content==null?false:true;
	}
	
	public String getSort() {
		// TODO Auto-generated method stub
		return sort;
	}
		
	public int getTotalPages() {
		// TODO Auto-generated method stub
		return this.totalPages;
	}

	
	public boolean hasPreviousPage() {
		// TODO Auto-generated method stub
	 return this.number>1?true:false;
	}


	public boolean isFirstPage() {
		// TODO Auto-generated method stub
		return this.number==1?true:false;
	}

	
	public boolean hasNextPage() {
		// TODO Auto-generated method stub
		return this.number<this.totalPages?true:false;
	}

	public boolean isLastPage() {
		// TODO Auto-generated method stub
		return this.number==this.totalPages?true:false;
	}

}
