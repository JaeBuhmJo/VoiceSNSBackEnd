package com.service.VoiceSNS.dao;

import java.util.HashMap;
import java.util.List;

import com.service.VoiceSNS.domain.Connection;
public interface ConnectDAO {
	
	int insertConnect(int user_id_one, int user_id_two);
	HashMap getConnect(int user_id_one, int user_id_two);
	List<HashMap> getConnects(int user_id);
	int deleteConnect(int user_id_one, int user_id_two);

}
