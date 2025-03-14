package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.bean.TypingTestBean;
import com.example.bean.UserBean;
import com.example.repowrapper.TypingTestRepoWrapper;
import com.example.service.TypingTestService;

@RestController
@RequestMapping("/api")
public class TypingTestcontroller {

	@Autowired
	TypingTestService typingTestService;
//	Commenting Out all the other Post mapping of start,stop and save instead keeping it one for simpler understanding

//	@PostMapping("/Typing/start")
//	public int startTest(@RequestBody UserBean user) {
//		int testId=typingTestService.startTypingTest();
//		return testId;
//	}
//
//	@PostMapping("/Typing/stop/{testId}")
//	public void stopTest(int testId) {
//		 typingTestService.stopTypingTest(testId);
//	}
//
//	@PostMapping("/Typing/test/save")
//	public TypingTestBean saveTest(@RequestBody TypingTestBean typingTestBean,UserBean user) {
//		return typingTestService.saveTypingTestService(typingTestBean, user);
//	}

	@PostMapping("/Typing/test/save")
	public TypingTestBean saveTest(@RequestBody TypingTestBean request) {
		return typingTestService.saveTypingTestService(request);
	}

	/* Testing mapping*/
	@PostMapping("/submit")
	public String handlePostRequest() {
		return "Post request successful!";
	}

}
