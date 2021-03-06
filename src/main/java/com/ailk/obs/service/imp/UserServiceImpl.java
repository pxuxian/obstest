package com.ailk.obs.service.imp;

import java.util.List;

import com.ailk.obs.dao.UserDao;
import com.ailk.obs.dao.impl.UserDaoImpl;
import com.ailk.obs.model.User;
import com.ailk.obs.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();

	// �Ƿ�ע��
	public boolean isRegister(User user) {
		String userName = user.getUserName();
		int userCount = userDao.getByUserName(userName);
		if (userCount > 0) {
			return false;
		} else {
			return true;
		}
	}

	// ע��
	public void register(User user) {
		userDao.addUser(user);
	}

	// �Ƿ���������
	public boolean login(User user) {
		String userName = user.getUserName();
		String passwd = user.getPassWd();
		List<String> userinfoDB = userDao.getUserByName(userName);
		String passWdDB = userinfoDB.get(1);
		if (passwd.equals(passWdDB)) {
			return true;
		} else {
			return false;
		}
	}
}
