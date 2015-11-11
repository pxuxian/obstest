package com.ailk.obs.service;

import com.ailk.obs.dao.UserDao;
import com.ailk.obs.dao.impl.UserDaoImpl;

public class UserService {
	

	//用户登入时判断用户是否注册过，注册过验证用户信息,未注册则跳转到注册页面
	//Is registered
public void isRegister(String userName){
	UserDao userDao = new UserDaoImpl();
	int userCount= userDao.getByUserName(userName);
	if(userCount > 0){
		//
	}else{
		
	}
	
}
}
