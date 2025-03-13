package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.TypingTestBean;
import com.example.bean.UserBean;
import com.example.repowrapper.TypingTestRepoWrapper;
import com.example.service.TypingTestService;

@RestController
public class TypingTestcontroller {

	@Autowired
	TypingTestService typingTestService;
	
	@PostMapping("/Typing/start")
	public int startTest(@RequestBody UserBean user) {
		int testId=typingTestService.startTypingTest();
		return testId;
	}
	
	@PostMapping("/Typing/stop/{testId}")
	public void stopTest(int testId) {
		 typingTestService.stopTypingTest(testId);
	}
	
	@PostMapping("/Typing/test/save")
	public TypingTestBean saveTest(@RequestBody TypingTestBean typingTestBean,UserBean user) {
		return typingTestService.saveTypingTestService(typingTestBean, user);
	}
}
