package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "texts")
public class TextEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int textId;
	
	@Column(nullable = false,length = 1000)
	private String content;
	
	@OneToMany(mappedBy = "textEntity",cascade = CascadeType.ALL)
	private List<TypingTestEntity> typingTestEntities;
	

	@Column(nullable = false)
	private String difficulty;

	public int getId() {
		return textId;
	}

	public void setId(int id) {
		this.textId = id;
	}

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
	
	public TextEntity() {}
}
