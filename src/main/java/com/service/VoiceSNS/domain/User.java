package com.service.VoiceSNS.domain;

import java.sql.Time;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private int userId;
	private String email;
	private String password;
	private String nickname;
	private byte[] profilePicture;
	private boolean alarmOn;
	private Time alarmTime;
	private boolean google;
	private boolean kakao;
	
	public User() {
		super();
	}

	// AUTO_INCREMENT인 userId 제외 user 생성자
	public User(String email, String password, String nickname, byte[] profilePicture, boolean alarmOn, Time alarmTime,
			boolean google, boolean kakao) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.profilePicture = profilePicture;
		this.alarmOn = alarmOn;
		this.alarmTime = alarmTime;
		this.google = google;
		this.kakao = kakao;
	}
	
	// login용 생성자
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	
	
	
	
}
