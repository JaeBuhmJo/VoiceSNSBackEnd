package com.service.VoiceSNS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.service.VoiceSNS.domain.Message;
import com.service.VoiceSNS.domain.User;
import com.service.VoiceSNS.service.AuthService;
import com.service.VoiceSNS.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
    private AuthService authService;
	
	@Autowired
	private JwtUtil jwtUtil;

	// login 요청 -> jwt 헤더에 포함하여 응답
    @PostMapping("/login")
    public ResponseEntity<Message> login(@RequestBody User user, HttpServletResponse response) {
    	if(authService.login(user)) {
    		String jwt = jwtUtil.generateToken(user.getEmail());
    		response.setHeader("Authorization", "Bearer " + jwt);
    		response.setHeader("Refresh-Token", jwtUtil.generateRefreshToken(user.getEmail()));
    		System.out.println("jwt " + jwt);
    		return ResponseEntity.ok(new Message("Login Success"));
    	} else {
    		return new ResponseEntity<>(new Message("Login info not matched"),HttpStatus.OK);
    	}
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody User user) {
    	authService.logout(user);
    	return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
    
    // refresh 토큰 기반으로 신규 jwt 발급 요청
    @PostMapping("/refresh")
    public ResponseEntity<Message> refreshToken(HttpServletRequest request, HttpServletResponse response) {
    	String refreshToken = request.getHeader("Refresh-Token");
    	System.out.println("AuthController : jwt refresh requested");
        if (jwtUtil.validateToken(refreshToken)) {
            String username = jwtUtil.extractUsername(refreshToken);
            String newJwt = jwtUtil.generateToken(username);
            String newRefreshToken = jwtUtil.generateRefreshToken(username);

            // 새로운 JWT와 리프레시 토큰을 응답에 포함
	        response.setHeader("Authorization", "Bearer " + newJwt);
	        response.setHeader("Refresh-Token", newRefreshToken);
	        
	        // 기존 리프레시 토큰은 블랙리스트 

	        System.out.println("refresh success");
            return ResponseEntity.ok(new Message("refreshed"));
        } else {
        	System.out.println("refresh failed");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new Message("Refresh token is invalid"));
        }
    }
}
