package com.service.VoiceSNS.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.VoiceSNS.domain.User;
import com.service.VoiceSNS.service.AuthService;
import com.service.VoiceSNS.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthService authService;
	
	// 회원가입
	@PostMapping("")
	public ResponseEntity<Map<String, String>> postUser(@RequestBody User user){
		System.out.println("postUser "+user);
		int result = userService.registerUser(user);
		Map<String, String> response = new HashMap<>();
		
		if (result==1) { // 회원가입 성공 시 로그인까지 완료시켜서 클라이언트에 응답
			System.out.println("회원가입 성공"+user);
			response = authService.login(user);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else { // 회원가입 실패 시 실패 메세지 응답
			System.out.println("회원가입 실패"+user);
			response.put("message", "회원가입 실패");
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
//	
//	@DeleteMapping("")
//	public ResponseEntity<T> deleteUser(int userId){
//	}
//	
//	// 로그인한 유저 본인의 전체 정보 불러오기
//	@GetMapping("")
//	public ResponseEntity<T> getUser(User user){
//	}
//	
//	// 친구 목록, 검색 등 다른 유저의 필요 정보 불러오기
//	@GetMapping("/{userId}")
//	public ResponseEntity<T> getUserByUserId(int userId){
//	}
//	
//	@PutMapping("/password")
//	public ResponseEntity<T> putUserPassword(int userId){
//	}
//
//	@PutMapping("/nickname")
//	public ResponseEntity<T> putUserNickname(int userId){
//	}
//	
//	@PutMapping("/profilepicture")
//	public ResponseEntity<T> putUserProfilePicture(int userId){
//	}
//	
//	@PutMapping("/alarmon")
//	public ResponseEntity<T> putUserAlarmOn(int userId){
//	}
//	
//	@PutMapping("/alarmtime")
//	public ResponseEntity<T> putUserAlarmTime(int userId){
//	}
//	
//	@PutMapping("/google")
//	public ResponseEntity<T> putUserGoogle(int userId){
//	}
//	
//	@PutMapping("/kakao")
//	public ResponseEntity<T> putUserKakao(int userId){
//	}
//	
	

}
