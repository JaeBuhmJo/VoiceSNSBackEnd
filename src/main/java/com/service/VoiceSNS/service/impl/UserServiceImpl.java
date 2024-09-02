package com.service.VoiceSNS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.VoiceSNS.dao.UserDAO;
import com.service.VoiceSNS.domain.User;
import com.service.VoiceSNS.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public int registerUser(User user) {
		System.out.println("registerUser " + user);
		return userDAO.insertUser(user);
	}

	@Override
	public int deleteUser(int userId) {
		return userDAO.deleteUser(userId);
	}
	
	@Override
	public User findUser(int userId) {	
		return userDAO.findUser(userId);
	}
	
	@Override
	public User getUserSelfInfo(String email) {
		return userDAO.getUserSelfInfo(email);
	}
	
	@Override
	public boolean checkUserCredentials(User user) {
		return userDAO.checkUserCredentials(user)==1;
	}
	
	@Override
	public int updateUserPassword(User user) {
		return userDAO.updateUserPassword(user);
	}

	@Override
	public int updateUserNickname(User user) {
		return userDAO.updateUserNickname(user);
	}

	@Override
	public int updateUserProfilePicture(User user) {
		return userDAO.updateUserProfilePicture(user);
	}

	@Override
	public int updateUserAlarmOn(User user) {
		return userDAO.updateUserAlarmOn(user);
	}

	@Override
	public int updateUserAlarmTime(User user) {
		return userDAO.updateUserAlarmTime(user);
	}

	@Override
	public int updateUserGoogle(User user) {
		return userDAO.updateUserGoogle(user);
	}

	@Override
	public int updateUserKakao(User user) {
		return userDAO.updateUserKakao(user);
	}
	

}
