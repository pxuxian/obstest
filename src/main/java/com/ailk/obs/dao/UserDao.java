package com.ailk.obs.dao;

import com.ailk.obs.model.User;

public interface UserDao {

	User getByUserName(String userName);
}
