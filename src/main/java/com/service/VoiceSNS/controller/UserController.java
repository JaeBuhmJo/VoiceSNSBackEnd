package com.service.VoiceSNS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.VoiceSNS.domain.Message;
import com.service.VoiceSNS.domain.User;
import com.service.VoiceSNS.service.UserService;
import com.service.VoiceSNS.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	// 회원가입
	@PostMapping("")
	public ResponseEntity<Message> postUser(@RequestBody User user, HttpServletResponse response){
		System.out.println("postUser "+user);
		int result = userService.registerUser(user);
		
		if (result==1) { // 회원가입 성공 시 jwt 생성 후 클라이언트에 응답
			System.out.println("회원가입 성공 "+user);
			String email = user.getEmail();
	        response.setHeader("Authorization", "Bearer " + jwtUtil.generateToken(email));
	        response.setHeader("Refresh-Token", jwtUtil.generateRefreshToken(email));
			return new ResponseEntity<>(new Message("회원가입 성공"), HttpStatus.OK);
		} else { // 회원가입 실패 시 실패 메세지 응답
			System.out.println("회원가입 실패"+user);
			return new ResponseEntity<>(new Message("회원가입 실패"), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
//	
//	@DeleteMapping("")
//	public ResponseEntity<T> deleteUser(int userId){
//	}
//	
	// 로그인한 유저 본인의 전체 정보 불러오기
	@GetMapping("")
	public ResponseEntity<User> getUser(HttpServletRequest request){
		String userEmail = (String) request.getAttribute("userEmail");
		User user = userService.getUserSelfInfo(userEmail);
		System.out.println("getUser " + user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
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
