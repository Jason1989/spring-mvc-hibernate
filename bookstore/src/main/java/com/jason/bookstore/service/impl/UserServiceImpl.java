package com.jason.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jason.bookstore.dao.UserDao;
import com.jason.bookstore.model.User;
import com.jason.bookstore.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Transactional(readOnly = true)
	public User findUser(User user) {
		return userDao.findUser(user);
	}

}
