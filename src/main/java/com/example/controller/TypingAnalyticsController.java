package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.TypingAnalyticsBean;
import com.example.bean.TypingTestBean;
import com.example.service.TypingAnalyticsService;

@RestController
public class TypingAnalyticsController {
	@Autowired
	public TypingAnalyticsService typingAnalyticsService;
	
	@GetMapping("/TypingAnalytics")
	public TypingAnalyticsBean updateDataController(@RequestBody TypingTestBean typingTestBean,@RequestParam int userId) {
		return typingAnalyticsService.updateDataService(typingTestBean,userId);
	}
}
