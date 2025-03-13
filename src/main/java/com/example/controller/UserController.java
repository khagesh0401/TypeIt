package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.UserBean;
import com.example.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@PostMapping("/user/register")
	public String add(@RequestBody UserBean userBean) {
		int id= userService.saveUser(userBean);
		return "User with id:- "+id+" registered successfully";
	}
}
