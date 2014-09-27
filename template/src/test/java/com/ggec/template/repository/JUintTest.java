/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.ggec.template.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ggec.template.entity.Task;
import com.ggec.template.entity.User;
import com.ggec.template.service.task.TaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
@ActiveProfiles("production")
public class JUintTest {

	@Autowired
	private UserDao userDao;

	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskDao taskDao;
	
//	@Test
//	public void test() throws Exception {
//		User user = userDao.findByLoginName("admin");
//		for(User u:list){
//			System.out.println(u.getLoginName()+":"+u.getLoginName());			
//		}
//		
//		System.out.println(user.getSalt());
//		
//	}
	
//	@Test
//	public void test1()throws Exception{
//	 List<Task> list=taskService.getAllTask();
//	 
//	 for(Task t:list){
//			System.out.println(t.getTitle()+":"+t.getUser().getName());
//			
//		}
//	}
	
//	@Test
//	public void test2()throws Exception{
//		 Task task = new Task();
//		 User user =  new User();
//		 user.setId(1L);
//		 task.setTitle("这个是测试");
//		 task.setDescription("描述一下测试结果");
//         task.setUser(user);		 
//	     taskDao.save(task);	
//	}
	
//	@Test
//	public void test3()throws Exception{
//		Map<String,Object> map = new HashMap();
//		map.put("title", "");
//		//System.out.println(taskDao.getRows(2L,map));
//		List<Task> list= taskDao.findAllByUser(2L,map, 1, 3,"");
//		
//		for(Task t:list){
//			System.out.println(t.getTitle()+":"+t.getUser().getName()+":"+t.getDescription());			
//		}
//		
//	}
	
	
	
}
