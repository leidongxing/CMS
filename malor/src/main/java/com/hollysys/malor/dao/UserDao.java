package com.hollysys.malor.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hollysys.malor.entity.User;

public interface UserDao {
    

	HashMap<?,?> queryByUserNameAndPassWord(@Param("username")String username,@Param("password")String password);
	
	User queryByUserName(String username);

	List<User> queryAll();

	List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);

}
