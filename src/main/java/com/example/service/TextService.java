package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.TextBean;
import com.example.repowrapper.TextRepoWrapper;

@Service
public class TextService {
	
	@Autowired
	TextRepoWrapper textRepoWrapper;
	
	public TextBean getRandomText() {
        TextBean textBean = textRepoWrapper.randomText();
        if(textBean == null) {
        	textBean.setContent("No Text Available");
        	return textBean;
        }
        else {
        	return textBean;
        }
    }
	
	public List<TextBean> findAll() {
		List<TextBean> textBeans = new ArrayList<>();
		textBeans = textRepoWrapper.findAll();
		return textBeans;
	}
	
}
