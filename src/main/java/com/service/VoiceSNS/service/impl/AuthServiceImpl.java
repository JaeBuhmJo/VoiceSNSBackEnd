package com.service.VoiceSNS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.VoiceSNS.domain.User;
import com.service.VoiceSNS.service.AuthService;
import com.service.VoiceSNS.service.UserService;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private UserService userService;
	
	@Override
	public Boolean login(User user) {
        Boolean isLoggedIn = false;
        // 인증 성공이면 true 리턴
        if (userService.checkUserCredentials(user)) {
        	isLoggedIn = true;
        }
        return isLoggedIn;
	}

	@Override
	public String logout(User user) {
    	
    	// 액세스 토큰 및 리프레시 토큰 블랙리스트 추가
		
		return "Success";
	}
	
}
