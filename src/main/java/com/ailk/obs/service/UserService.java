package com.ailk.obs.service;

import com.ailk.obs.dao.UserDao;
import com.ailk.obs.dao.impl.UserDaoImpl;

public class UserService {
	

	//�û�����ʱ�ж��û��Ƿ�ע�����ע�����֤�û���Ϣ,δע������ת��ע��ҳ��
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
