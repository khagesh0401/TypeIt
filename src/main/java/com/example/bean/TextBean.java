package com.example.bean;

import java.beans.JavaBean;


import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@JavaBean
public class TextBean {
	
	private String content;
	
	@Column(name = "difficulty")
	private String difficulty;
	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	
}
