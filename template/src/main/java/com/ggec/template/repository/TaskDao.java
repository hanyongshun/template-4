/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ggec.template.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ggec.template.entity.Task;

/**
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 * @author calvin
 */
@MyBatisRepository
public interface TaskDao {

	Task findOne(Long id);
	
	void save(Task task);
	
	void delete(Long id);
	
	List<Task> findByUserId(Long id);
	
	List<Task> findAll();
	
	List<Task> findAllByUser(
			           @Param("userId") Long userId,
			           @Param("searchParams") Map<String, Object> searchParams, 
			           @Param("pageNumber") int pageNumber, 
			           @Param("pageSize")  int pageSize, 
			           @Param("sortType")  String sortType);
	
    void deleteByUserId(Long id);

	int getRows(@Param("userId")Long userId,@Param("searchParams")Map<String, Object> searchParams);
}
