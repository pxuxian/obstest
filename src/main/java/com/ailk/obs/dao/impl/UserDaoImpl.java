package com.ailk.obs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.ailk.obs.dao.UserDao;
import com.ailk.obs.db.DBUtil;
import com.ailk.obs.model.User;

public class UserDaoImpl implements UserDao {

	// 通过username查找用户，返回记录条数
	public int getByUserName(String userName) {

		String sql = "select " + '*' + " from " + "user" + " where " + "userName" + " = " + userName;
		System.out.println("sql === " + sql);
		return DBUtil.executeSelect(sql);
	}

	// 用户信息入库
	public void addUser(User user) {
		
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into t_user(userId,userName,passWd,phone,mail,sex,summary,address) valuse(?,?,?,?,?,?,?,?)");
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getPassWd());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getMail());
			ps.setInt(6,user.getSex());
			ps.setString(7, user.getSummary());
			ps.setString(8, user.getSummary());
			ps.setDate(9, user.getCreatetime());
			ps.executeUpdate();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
