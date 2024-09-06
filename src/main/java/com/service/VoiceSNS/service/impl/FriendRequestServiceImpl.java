package com.service.VoiceSNS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.VoiceSNS.dao.FriendRequestDAO;

import com.service.VoiceSNS.domain.FriendRequest;
import com.service.VoiceSNS.service.FriendRequestService;

@Service
public class FriendRequestServiceImpl implements FriendRequestService {
	@Autowired
	private FriendRequestDAO friendRequestDAO;

	@Override
	public int registerFriendRequest(FriendRequest friendRequest) {
		// TODO Auto-generated method stub
		return friendRequestDAO.insertFriendRequest(friendRequest);
	}

	@Override
	public FriendRequest getFriendRequestById(int requestId) {
		// TODO Auto-generated method stub
		return friendRequestDAO.getFriendRequestById(requestId);
	}

	@Override
	public int updateFriendRequestStatus(int requestId, String staus) {
		// TODO Auto-generated method stub
		return friendRequestDAO.updateFriendRequestStatus(requestId, staus);
	}

	@Override
	public List<FriendRequest> getFriendRequestsByUserId(int userId) {
		// TODO Auto-generated method stub
		return friendRequestDAO.getFriendRequestsByUserId(userId);
	}

}
