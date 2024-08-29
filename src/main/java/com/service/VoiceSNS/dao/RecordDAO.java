package com.service.VoiceSNS.dao;

import com.service.VoiceSNS.domain.Record;

public interface RecordDAO {
	int insertRecord(Record record);
	int insertIntoPost(Record record);
	Record getRecord(int recordId);
	Record getUserRecord(int recordId, int userId);
	int deleteUnselectedRecords(int userId);
	int deleteAllRecords();
}
