package com.example.entity;

import java.util.List;

import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false,unique = true)
	private String username;
	
	
	@OneToMany(mappedBy = "userEntity",cascade = jakarta.persistence.CascadeType.ALL)
	private List<TypingTestEntity> typingtest;
	
	@OneToOne(mappedBy = "userEntity",cascade = jakarta.persistence.CascadeType.ALL)
	private TypingAnalyticsEntity typinganalyticsEntity;
	
	@OneToMany(mappedBy = "userEntity",cascade = jakarta.persistence.CascadeType.ALL)
	private List<LeaderBoardEntity> leaderboardEntities;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
