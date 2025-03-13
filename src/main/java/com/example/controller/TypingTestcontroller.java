package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.TypingTestBean;
import com.example.bean.UserBean;
import com.example.service.TypingTestService;

@RestController
@RequestMapping("/Typing")
public class TypingTestcontroller {

	@Autowired
	TypingTestService typingTestService;
	
	@PostMapping("/start")
	public int startTest(@RequestBody UserBean user) {
		int testId=typingTestService.startTypingTest();
		return testId;
	}
	
	@PostMapping("/stop/{testId}")
	public void stopTest(int testId) {
		 typingTestService.stopTypingTest(testId);
	}
	
	@PostMapping("/test/save")
	public TypingTestBean saveTest(@RequestBody TypingTestBean typingTestBean,UserBean user) {
		return typingTestService.saveTypingTestService(typingTestBean, user);
	}
}
