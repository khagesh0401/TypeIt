package com.example.repowrapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bean.TextBean;
import com.example.bean.TypingTestBean;
import com.example.entity.TextEntity;
import com.example.entity.TypingTestEntity;
import com.example.repo.TextRepo;

@Component
public class TextRepoWrapper {
	
	@Autowired
	TextRepo textRepo;
	
	public TextBean randomText() {
		TextBean textBean=new TextBean();
		if(textRepo.findRandomText()!=null) {
		 textBean=entitytoBean(textRepo.findRandomText());}
		return textBean;
	}
	
	public TextEntity beantoEntity(TextBean textBean) {
		TextEntity textEntity= new TextEntity();
		BeanUtils.copyProperties(textBean, textEntity);
		return textEntity;
	}
	
	public TextBean entitytoBean(TextEntity textEntity) {
		TextBean textBean = new TextBean();
		BeanUtils.copyProperties(textEntity, textBean);
		return textBean;
	}
}
