package com.ailk.obs.dao;

import org.junit.Test;

import com.ailk.obs.dao.impl.UserDaoImpl;
import com.ailk.obs.model.User;

import junit.framework.Assert;

public class UserDaoTest {

	@Test
	public void testGet() {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getByUserName("wangjing");
		Assert.assertEquals(true, user != null);
	}
}
