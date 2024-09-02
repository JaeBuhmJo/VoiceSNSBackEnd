package com.service.VoiceSNS.service;

import com.service.VoiceSNS.domain.User;

public interface UserService {
	int registerUser(User user);
	int deleteUser(int userId);
	User findUser(int userId);
	User getUserSelfInfo(String email);
	boolean checkUserCredentials(User user);
	int updateUserPassword(User user);
	int updateUserNickname(User user);
	int updateUserProfilePicture(User user);
	int updateUserAlarmOn(User user);
	int updateUserAlarmTime(User user);
	int updateUserGoogle(User user);
	int updateUserKakao(User user);
}
