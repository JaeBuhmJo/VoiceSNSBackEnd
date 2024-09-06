package com.service.VoiceSNS.controller;

import java.sql.Timestamp;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.VoiceSNS.domain.Connection;
import com.service.VoiceSNS.domain.FriendRequest;
import com.service.VoiceSNS.domain.User;
import com.service.VoiceSNS.service.ConnectService;
import com.service.VoiceSNS.service.FriendRequestService;
import com.service.VoiceSNS.service.UserService;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping("/connection")
public class ConnectController {
   
   @Autowired
   private UserService userService;
   
   @Autowired
   private ConnectService connectService;
   
   @Autowired
   private FriendRequestService friendRequestService;
   
   @GetMapping("/check-friend/{userId}/{searchUserId}")
   public ResponseEntity<FriendCheckResponse> checkFriendStatus(
           @PathVariable("userId") int userId,
           @PathVariable("searchUserId") int searchUserId) {
       
       // 유저가 존재하는지 확인

       User searchUser = userService.findUser(searchUserId);
       
       if (searchUser == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 유저가 존재하지 않는 경우 404 응답
       }
       
       // 친구 관계 확인
       HashMap connect = connectService.searhConnect(userId, searchUserId);
       System.out.println(connect);
       System.out.println(userId);
       System.out.println(searchUserId);
       
       // 응답 객체 생성
       FriendCheckResponse response = new FriendCheckResponse(connect, searchUser);
       
       // 결과 반환
       return new ResponseEntity<>(response, HttpStatus.OK);
   }
   
// 친구 관계 확인 응답 객체
   @Data
   static class FriendCheckResponse {

       private HashMap connect;
       private User user;
       
       public FriendCheckResponse(HashMap connect, User user) {
    	   this.connect = connect;
    	   this.user = user;
		// TODO Auto-generated constructor stub
	}

      
   }


}
