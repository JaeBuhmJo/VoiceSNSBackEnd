package com.service.VoiceSNS.service;

import java.util.HashMap;

import com.service.VoiceSNS.domain.Connection;

public interface ConnectService {
	HashMap searhConnect(int sender_user_id, int receiver_user_id);
	int insertConnect(int sender_user_id, int receiver_user_id);
	int deleteConnect(int sender_user_id, int receiver_user_id);
	

}
