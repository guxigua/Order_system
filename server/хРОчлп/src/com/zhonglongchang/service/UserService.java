package com.zhonglongchang.service;

import com.zhonglongchang.Dao.UserDao;
import com.zhonglongchang.entity.User;

public class UserService {
	public boolean checkUser(String name,String pass) {
		UserDao us=new UserDao();
		return us.checkUser(name, pass);
	}
	public User getUser(String name) {
		UserDao us=new UserDao();
		return us.getUser(name);
	}
	public boolean checkName(String name) {
		UserDao us=new UserDao();
		return us.checkName(name);
	}
	public boolean adduser(String name,String pass,String address) {
		UserDao us=new UserDao();
		return us.adduser(name, pass,address);
	}
}
