package com.ailk.obs.dao;

import com.ailk.obs.model.User;


public interface UserDao {
	//�����Ƿ��м�¼
	int getByUserName(String userName);
	//�û���Ϣ���
	void addUser(User user);
	
	
}
