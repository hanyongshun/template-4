/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ggec.template.repository;

import java.util.List;
import java.util.Map;
import com.ggec.template.entity.User;
/**
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 * @author ljh
 */
@MyBatisRepository
public interface UserDao {

	User get(Long id);

	List<User> search(Map<String, Object> parameters);

	void save(User user);
	
	void update(User user);
	
	void delete(Long id);
	
	List<User> findAll();
	
	User findOne(Long id);
	
	User findByLoginName(String loginName);
	
}
