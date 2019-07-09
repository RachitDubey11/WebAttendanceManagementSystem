package com.projectspring.service;

import com.projectspring.model.User;

public interface UserService {

	User findById(int id);
	
	User findBySso(String userName);
	
}