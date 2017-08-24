package com.hollysys.malor.test;

import java.sql.Timestamp;
import java.util.HashMap;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hollysys.malor.dao.UserDao;
import com.hollysys.malor.entity.User;

public class UserTest extends BaseTest {
	@Autowired
	private UserDao userDao;

	@Test
	public void testQueryByUserName() throws Exception {
		String username = "admin";
		User user = userDao.queryByUserName(username);
		HashMap<?,?> userMap = userDao.queryByUserNameAndPassWord("admin", "admin");
		System.out.println(userMap.get("last_time"));
	}
}
