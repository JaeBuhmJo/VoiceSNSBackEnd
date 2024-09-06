package com.service.VoiceSNS.service;

import java.util.List;


import com.service.VoiceSNS.domain.FriendRequest;


public interface FriendRequestService {

	int registerFriendRequest(FriendRequest friendRequest);
	FriendRequest getFriendRequestById(int requestId);
	int updateFriendRequestStatus(int requestId, String staus);
	List<FriendRequest> getFriendRequestsByUserId(int userId);
	
}
