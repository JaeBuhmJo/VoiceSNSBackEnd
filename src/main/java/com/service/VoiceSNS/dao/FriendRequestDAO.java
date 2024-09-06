package com.service.VoiceSNS.dao;

import java.util.List;

import com.service.VoiceSNS.domain.FriendRequest;

public interface FriendRequestDAO {

    int insertFriendRequest(FriendRequest friendRequest);
    FriendRequest getFriendRequestById(int requestId);
    int updateFriendRequestStatus(int requestId, String staus);
    List<FriendRequest> getFriendRequestsByUserId(int userId);
}
