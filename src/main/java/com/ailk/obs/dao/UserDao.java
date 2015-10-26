package com.ailk.obs.dao;

import com.ailk.obs.model.User;


public interface UserDao {
	//库中是否有记录
	int getByUserName(String userName);
	//用户信息入库
	void addUser(User user);
	
	
}
