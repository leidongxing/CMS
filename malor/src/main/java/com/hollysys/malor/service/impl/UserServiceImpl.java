package com.hollysys.malor.service.impl;

import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hollysys.malor.dao.UserDao;
import com.hollysys.malor.entity.User;
import com.hollysys.malor.service.UserService;

public class UserServiceImpl implements UserService{
    
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public List<User> queryAll() {
		return userDao.queryAll();
	}

	@Override
	public List<User> queryAll(int offset, int limit) {
		return userDao.queryAll(offset, limit);
	}

	
	@Override
	public HashMap<?,?> queryByUserNameAndPassWord(String username, String password) {
		return userDao.queryByUserNameAndPassWord(username, password);
	}

	@Override
	public User queryByUserName(String username) {
		return userDao.queryByUserName(username);
	}


}
