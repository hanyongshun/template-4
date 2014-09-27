/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ggec.template.service.task;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ggec.template.entity.Task;
import com.ggec.template.repository.TaskDao;
import com.ggec.template.utils.JdbcPage;
import com.ggec.template.utils.JdbcSearchFilter;
import com.ggec.template.utils.JdbcSearchFilter.Operator;

// Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class TaskService {
	private TaskDao taskDao;
	public Task getTask(Long id) {
		return taskDao.findOne(id);
	}

	public void saveTask(Task entity) {
		taskDao.save(entity);
	}

	public void deleteTask(Long id) {
		taskDao.delete(id);
	}

	public List<Task> getAllTask() {
		return (List<Task>) taskDao.findAll();
	}

	public JdbcPage<Task> getUserTask(Long userId, Map<String, Object> searchParams, int pageNumber, int pageSize,
			String sortType) {
		int totalPage=0;
		int rows = taskDao.getRows(userId,searchParams);
	        totalPage = (int)(rows/pageSize);
		if (rows % pageSize != 0) {
			totalPage++;
		}
		searchParams = JdbcSearchFilter.parse(searchParams);
		List<Task> list =taskDao.findAllByUser(userId,searchParams,  pageNumber, pageSize, sortType);
		JdbcPage<Task> taskPage = new JdbcPage<Task>(list,pageNumber,pageSize,sortType,totalPage);		
		return taskPage;
	}

	
	/**
	 * 创建动态查询条件组合.
	 */


	@Autowired
	public void setTaskDao(TaskDao taskDao) {
		this.taskDao = taskDao;
	}
}
