package com.hollysys.malor.service;

import java.util.HashMap;
import java.util.List;

import com.hollysys.malor.entity.User;

public interface UserService {
    HashMap<?,?> queryByUserNameAndPassWord(String username,String password);
	
	User queryByUserName(String username);

	List<User> queryAll();

	List<User> queryAll(int offset, int limit);
}
