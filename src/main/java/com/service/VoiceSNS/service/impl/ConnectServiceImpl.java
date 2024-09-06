package com.service.VoiceSNS.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.VoiceSNS.dao.ConnectDAO;
import com.service.VoiceSNS.domain.Connection;
import com.service.VoiceSNS.service.ConnectService;


@Service
public class ConnectServiceImpl implements ConnectService{
	
	@Autowired
	private ConnectDAO connectDAO;

	@Override
	public HashMap searhConnect(int sender_user_id, int receiver_user_id) {
		System.out.println("=============SERVICE===============");
		System.out.println(sender_user_id);
	    System.out.println(receiver_user_id);
	    
	    HashMap connect =  connectDAO.getConnect(sender_user_id, receiver_user_id);
	    System.out.println(connect);
	    
		return connect;
	}

	@Override
	public int insertConnect(int sender_user_id, int receiver_user_id) {

		return connectDAO.insertConnect(sender_user_id,receiver_user_id);
	}
	@Override
	public int deleteConnect(int sender_user_id, int receiver_user_id) {
		// TODO Auto-generated method stub
		return connectDAO.deleteConnect(sender_user_id, receiver_user_id);
	}
	
										

}
