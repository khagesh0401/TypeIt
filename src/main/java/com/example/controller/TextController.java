package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bean.TextBean;
import com.example.service.TextService;

@Controller
@RequestMapping("/Typing")
public class TextController {
	
	@Autowired
	TextService textService;
	
	@GetMapping("/test")
	public String randomText() {
		//check this one
		return textService.getRandomText().getContent();
	}
}
