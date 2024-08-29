package com.service.VoiceSNS.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.service.VoiceSNS.dao.RecordDAO;
import com.service.VoiceSNS.domain.Record;

public class RecordDAOImpl implements RecordDAO{

	private final String NS = "RecordMapper.";
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertRecord(Record record) {
		return sqlSession.insert(NS + "insertRecord", record);
	}
	
	@Override
	public int insertIntoPost(Record record) {
		return sqlSession.insert(NS + "insertIntoPost", record);
	}
	
	@Override
	public Record getRecord(int recordId) {
		return sqlSession.selectOne(NS + "getRecord", recordId);
	}
	
	@Override
	public Record getUserRecord(int recordId, int userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("recordId", recordId);
		params.put("userId", userId);
		return sqlSession.selectOne(NS + "getUserRecord", params);
	}

	@Override
	public int deleteUnselectedRecords(int userId) {
		return sqlSession.delete(NS + "deleteUnselectedRecords", userId);
	}
	
	@Override
	@Scheduled(cron = "0 0 4 * * ?")
	public int deleteAllRecords() {
		return sqlSession.delete(NS + "deleteAllRecords");
	}
}
