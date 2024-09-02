package com.service.VoiceSNS.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.VoiceSNS.domain.User;
import com.service.VoiceSNS.service.AuthService;
import com.service.VoiceSNS.service.UserService;
import com.service.VoiceSNS.util.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Map<String, String> login(User user) {
    	
        String email = user.getEmail();
        String password = user.getPassword();
        Map<String, String> response = new HashMap<>();

        // 사용자 인증 성공 시 access token과 refresh token 생성
        if (validateUser(new User(email, password))) {
            String token = jwtUtil.generateToken(email);
            String refreshToken = jwtUtil.generateRefreshToken(email);
            
            response.put("accessToken", token);
            response.put("refreshToken", refreshToken);
        } else {
        	response.put("message", "Need Login");
        }
        
        return response;
	}

	@Override
	public String logout(User user) {
    	
    	// 액세스 토큰 및 리프레시 토큰 블랙리스트 추가
		
		return "Success";
	}
	
	// User 정보가 정확히 1명 배출될 경우 로그인 정보 유효
	@Override
	public boolean validateUser(User user) {
		return userService.checkUserCredentials(user);
	}

}
