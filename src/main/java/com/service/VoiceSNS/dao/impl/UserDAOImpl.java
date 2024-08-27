package com.service.VoiceSNS.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.VoiceSNS.dao.UserDAO;
import com.service.VoiceSNS.domain.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private final String NS = "UserMapper.";
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertUser(User user) {
		return sqlSession.insert(NS+"insertUser", user);
	}

	@Override
	public int deleteUser(int userId) {
		return sqlSession.delete(NS+"deleteUser", userId);
	}
	
	@Override
	public User findUser(int userId) {
		return sqlSession.selectOne(NS+"findUser", userId);
	}
	
	@Override
	public User getUserInfo(User user) {
		return sqlSession.selectOne(NS+"getUserInfo", user);
	}
	
	@Override
	public int updateUserPassword(User user) {
		return sqlSession.update(NS+"updateUserPassword", user);
	}

	@Override
	public int updateUserNickname(User user) {
		return sqlSession.update(NS+"updateUserNickname", user);
	}

	@Override
	public int updateUserProfilePicture(User user) {
		return sqlSession.update(NS+"updateUserProfilePicture", user);
	}

	@Override
	public int updateUserAlarmOn(User user) {
		return sqlSession.update(NS+"updateUserAlarmOn", user);
	}

	@Override
	public int updateUserAlarmTime(User user) {
		return sqlSession.update(NS+"updateUserAlarmTime", user);
	}

	@Override
	public int updateUserGoogle(User user) {
		return sqlSession.update(NS+"updateUserGoogle", user);
	}

	@Override
	public int updateUserKakao(User user) {
		return sqlSession.update(NS+"updateUserKakao", user);
	}

}
