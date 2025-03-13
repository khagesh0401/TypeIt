package com.example.bean;

import java.beans.JavaBean;

import com.example.entity.TextEntity.Difficulty;

@JavaBean
public class TextBean {
	
	private String content;
	private Difficulty difficulty;
	
	public enum Difficulty{
		EASY,MEDIUM,HARD
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	
	
}
