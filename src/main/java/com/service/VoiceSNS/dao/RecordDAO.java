package com.service.VoiceSNS.dao;

import com.service.VoiceSNS.domain.Record;

public interface RecordDAO {
	Record getRecord(int recordId, int userId);
	int insertRecord(Record record);
	int insertIntoPost(Record record);
	int deleteUnselectedRecords(int userId);
	int deleteAllRecords();
}
