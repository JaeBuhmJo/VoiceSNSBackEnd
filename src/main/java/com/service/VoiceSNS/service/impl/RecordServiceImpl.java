package com.service.VoiceSNS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.service.VoiceSNS.dao.RecordDAO;
import com.service.VoiceSNS.domain.Record;
import com.service.VoiceSNS.service.RecordService;

public class RecordServiceImpl implements RecordService{
	
	@Autowired
	private RecordDAO recordDAO;

	@Override
	public Record getRecord(int recordId, int userId) {
		return recordDAO.getRecord(recordId, userId);
	}

	@Override
	public int registerRecord(Record record) {
		return recordDAO.insertRecord(record);
	}

	@Override
	public int registertIntoPost(Record record) {
		return recordDAO.insertIntoPost(record);
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
