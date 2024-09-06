package com.service.VoiceSNS.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendRequest {
	
    private int requestId;
    private int senderId;
    private int receiverId;
    private String status; // 'pending', 'accepted', 'rejected'
    private Timestamp sentAt;
    private Timestamp respondedAt;

}
