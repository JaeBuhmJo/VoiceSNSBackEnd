package com.service.VoiceSNS.service;

import com.service.VoiceSNS.domain.User;

public interface AuthService {
	Boolean login(User user);
	String logout(User user);
}
