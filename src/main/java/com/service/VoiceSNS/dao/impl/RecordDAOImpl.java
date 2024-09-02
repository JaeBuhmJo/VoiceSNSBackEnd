package com.service.VoiceSNS.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import com.service.VoiceSNS.dao.RecordDAO;
import com.service.VoiceSNS.domain.Record;

@Repository
public class RecordDAOImpl implements RecordDAO{

	private final String NS = "RecordMapper.";
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Record insertRecord(Record record) {
		int rowsAffected = sqlSession.insert(NS + "insertRecord", record);
        if (rowsAffected > 0) {
            // 삽입이 성공하면 record 객체를 반환
            return record;
        } else {
            throw new RuntimeException("Failed to insert record");
        }
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
	public List<Record> getUserRecords(int userId) {
		return sqlSession.selectOne(NS + "getUserRecords", userId);
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
