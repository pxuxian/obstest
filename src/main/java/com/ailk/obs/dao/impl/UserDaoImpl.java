package com.ailk.obs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import com.ailk.obs.dao.UserDao;
import com.ailk.obs.db.DBUtil;
import com.ailk.obs.model.User;

public class UserDaoImpl implements UserDao {
	private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);

	// 通过username查找用户，返回记录条数
	public int getByUserName(String userName) {
		String sql = "select * from t_user where userName='" + userName + "'";
		LOG.info("sql === " + sql);
		return DBUtil.executeSelect(sql);
	}

	// 通过username查找用户，返回username和passwd
	public List<String> getUserByName(String userName) {
		String sql = "select  username,passwd from  t_user where userName = '" + userName + "'";
		LOG.info("sql === " + sql);
		List<String> userList = DBUtil.executeSelectRS(sql);
		return userList;
	}

	// 用户信息入库
	public void addUser(User user) {
		Connection conn = DBUtil.getConnection();
		try {
			String sql = "insert into t_user(userName,passWd,phone,mail,sex,summary,address,createtime) values(?,?,?,?,?,?,?,now())";
			PreparedStatement ps = conn.prepareStatement(sql);
			LOG.info("sql === " + sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassWd());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getMail());
			ps.setString(5, user.getSex());
			ps.setString(6, user.getSummary());
			ps.setString(7, user.getSummary());
			ps.executeUpdate();
			ps.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
