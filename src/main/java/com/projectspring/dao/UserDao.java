package com.projectspring.dao;

import com.projectspring.model.User;

public interface UserDao {

	User findById(int id);
	User findBySSO(String userName);
	
}

