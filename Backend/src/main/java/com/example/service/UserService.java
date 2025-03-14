package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.UserBean;
import com.example.repowrapper.UserRepoWrapper;

@Service
public class UserService {
	
	@Autowired
	public UserRepoWrapper userRepoWrapper;
	
	public int saveUser(UserBean userBean) {
	return userRepoWrapper.saveUser(userBean);

	}
}
