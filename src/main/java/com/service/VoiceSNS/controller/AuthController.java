package com.service.VoiceSNS.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.service.VoiceSNS.domain.User;
import com.service.VoiceSNS.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User user) {
    	Map<String, String> response = authService.login(user);
    	HttpStatus httpStatus = response.containsKey("accessToken") ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
    	return new ResponseEntity<>(response, httpStatus);
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody User user) {
    	authService.logout(user);
    	return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
