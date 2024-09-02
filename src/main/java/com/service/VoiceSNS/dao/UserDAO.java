package com.service.VoiceSNS.dao;

import com.service.VoiceSNS.domain.User;

public interface UserDAO {
	int insertUser(User user);
	int deleteUser(int userId);
	User findUser(int userId);
	User getUserSelfInfo(String email);
	int checkUserCredentials(User user);
	// user update는 각각의 버튼을 통해서 이뤄지므로 db 접근을 구분한다
	int updateUserPassword(User user);
	int updateUserNickname(User user);
	int updateUserProfilePicture(User user);
	int updateUserAlarmOn(User user);
	int updateUserAlarmTime(User user);
	int updateUserGoogle(User user);
	int updateUserKakao(User user);
}
