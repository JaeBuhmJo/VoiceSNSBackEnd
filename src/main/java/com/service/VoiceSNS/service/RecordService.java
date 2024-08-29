package com.service.VoiceSNS.service;

import com.service.VoiceSNS.domain.Record;

public interface RecordService {
	int registerRecord(Record record);
	int registertIntoPost(Record record);
	Record getRecord(int recordId);
	Record getUserRecord(int recordId, int userId);
	int deleteUnselectedRecords(int userId);
	int deleteAllRecords();
}
