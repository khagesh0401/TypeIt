package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.TextBean;
//import com.example.bean.TextBean.Difficulty;
import com.example.service.TextService;

@RestController
@RequestMapping("/Typing")
public class TextController {
	
	@Autowired
	TextService textService;
	
	@GetMapping("/test")
	public TextBean randomText() {
		//check this one
//		return textService.getRandomText().getDifficulty();
		return textService.getRandomText();
	}
	
	@GetMapping("/all")
	public List<TextBean> getAll(){
		return textService.findAll();
	}
}
