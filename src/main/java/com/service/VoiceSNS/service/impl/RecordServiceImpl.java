package com.service.VoiceSNS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.VoiceSNS.dao.RecordDAO;
import com.service.VoiceSNS.domain.Record;
import com.service.VoiceSNS.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService{
	
	@Autowired
	private RecordDAO recordDAO;

	@Override
	public Record registerRecord(Record record) {
		return recordDAO.insertRecord(record);
	}

	@Override
	public int registertIntoPost(Record record) {
		return recordDAO.insertIntoPost(record);
	}
	
	@Override
	public Record getRecord(int recordId) {
		return recordDAO.getRecord(recordId);
	}
	
	@Override
	public List<Record> getUserRecords(int userId) {
		return recordDAO.getUserRecords(userId);
	}

	@Override
	public int deleteUnselectedRecords(int userId) {
		return recordDAO.deleteUnselectedRecords(userId);
	}

	@Override
	public int deleteAllRecords() {
		return recordDAO.deleteAllRecords();
	}


}
