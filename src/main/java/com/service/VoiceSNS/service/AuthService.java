package com.service.VoiceSNS.service;

import java.util.Map;

import com.service.VoiceSNS.domain.User;

public interface AuthService {
	Map<String, String> login(User user);
	String logout(User user);
	boolean validateUser(User user);
}
