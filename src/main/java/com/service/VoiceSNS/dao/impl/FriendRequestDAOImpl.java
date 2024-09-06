package com.service.VoiceSNS.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.VoiceSNS.dao.FriendRequestDAO;
import com.service.VoiceSNS.domain.FriendRequest;

@Repository
public class FriendRequestDAOImpl implements FriendRequestDAO {
	
	private final String NS = "FriendRequestMapper.";
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertFriendRequest(FriendRequest friendRequest) {
		return sqlSession.insert(NS + "insertfriendRequest", friendRequest);
	}

	@Override
	public FriendRequest getFriendRequestById(int requestId) {
		return sqlSession.selectOne(NS + "getFriendRequest",requestId );
	}

	@Override
	public int updateFriendRequestStatus(int requestId, String status) {
		Map<String, Object> params = new HashMap<>();
		params.put("requestId", requestId);
		params.put("status", status);
		return sqlSession.update(NS+"updateFriendRequestStatus", params);
	}


	@Override
	public List<FriendRequest> getFriendRequestsByUserId(int userId) {
		return sqlSession.selectList(NS + "getFriendRequestsByUserId", userId);
	}

}
