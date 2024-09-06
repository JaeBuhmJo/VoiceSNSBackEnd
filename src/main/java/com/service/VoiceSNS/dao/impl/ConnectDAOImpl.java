package com.service.VoiceSNS.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.VoiceSNS.dao.ConnectDAO;
import com.service.VoiceSNS.domain.Connection;

@Repository
public class ConnectDAOImpl implements ConnectDAO{
	
	private final String NS = "ConnectMapper.";
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertConnect(int user_id_one, int user_id_two) {
		Map<String, Object> params = new HashMap<>();
		params.put("user_id_one", user_id_one);
		params.put("user_id_two", user_id_two);

		return sqlSession.insert(NS + "insertConnect", params);
	}

	@Override
	public HashMap getConnect(int user_id_one, int user_id_two) {
		
		System.out.println("============CONNECT===============");
		System.out.println(user_id_one);
	    System.out.println(user_id_two);
		Map<String, Object> params = new HashMap<>();
		params.put("user_id_one", user_id_one);
		params.put("user_id_two", user_id_two);
		
		HashMap connect = sqlSession.selectOne(NS + "getConnect",params );
		System.out.println(connect);
		
		return connect;
	}

	@Override
	public List<HashMap> getConnects(int user_id) {

		return sqlSession.selectList(NS + "getConnects",user_id );
	}

	@Override
	public int deleteConnect(int user_id_one, int user_id_two) {

	
		Map<String, Object> params = new HashMap<>();
		params.put("user_id_one", user_id_one);
		params.put("user_id_two", user_id_two);
		return sqlSession.delete(NS + "deleteConnect", params);
	}

}
