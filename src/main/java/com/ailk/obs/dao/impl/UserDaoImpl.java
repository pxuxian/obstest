package com.ailk.obs.dao.impl;

import com.ailk.obs.dao.UserDao;
import com.ailk.obs.db.DBUtil;
import com.ailk.obs.model.User;

public class UserDaoImpl implements UserDao {

	public int getByUserName(String userName) {

		String sql = "select " + '*' + " from " + "user" + " where " + "userName" + " = " + userName;
		System.out.println("sql === " + sql);
		return DBUtil.executeSelect(sql);
	}

	public void addUser(User user) {
	/*	private int userId;
		private String userName;
		private String passWd;
		private int phone;
		private String mail;
		private boolean sex;
		private String summary;
		private String address;
		 */
		
		String sql = "insert into t_user(userId,userName,passWd,phone,mail,sex,summary,address) valuse(?,?,?,?,?,?,?,?)";
		
		
		
	}

}
