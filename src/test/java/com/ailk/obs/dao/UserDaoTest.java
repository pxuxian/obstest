package com.ailk.obs.dao;

import java.sql.Date;

import org.junit.Test;

import com.ailk.obs.dao.impl.UserDaoImpl;
import com.ailk.obs.model.User;

import junit.framework.Assert;

public class UserDaoTest {

	@Test
	public void testGet() {
		UserDao userDao = new UserDaoImpl();
	//	User user = userDao.getByUserName("wangjing");
		//Assert.assertEquals(true, user != null);
	}
	

	
	@Test
	public void testSet(){
		UserDao userDao = new UserDaoImpl();
		
		User user = new User();
		user.setUserName("wangjing");
		user.setPassWd("wangjing");
		user.setPhone("13577777777");
		user.setMail("wangjing@163.com");
		user.setSex(0);
		user.setSummary("beijing");
		user.setAddress("beijing");
		userDao.addUser(user);
		
		
	}
	
}
