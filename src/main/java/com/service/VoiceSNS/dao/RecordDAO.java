package com.service.VoiceSNS.dao;

import java.util.List;

import com.service.VoiceSNS.domain.Record;

public interface RecordDAO {
	Record insertRecord(Record record);
	int insertIntoPost(Record record);
	Record getRecord(int recordId);
	List<Record> getUserRecords(int userId);
	int deleteUnselectedRecords(int userId);
	int deleteAllRecords();
}
