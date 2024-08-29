package com.service.VoiceSNS.service;

import com.service.VoiceSNS.domain.Record;

public interface RecordService {
	Record getRecord(int recordId, int userId);
	int registerRecord(Record record);
	int registertIntoPost(Record record);
	int deleteUnselectedRecords(int userId);
	int deleteAllRecords();
}
