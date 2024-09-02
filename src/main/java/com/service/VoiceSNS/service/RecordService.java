package com.service.VoiceSNS.service;

import java.util.List;

import com.service.VoiceSNS.domain.Record;

public interface RecordService {
	Record registerRecord(Record record);
	int registertIntoPost(Record record);
	Record getRecord(int recordId);
	List<Record> getUserRecords(int userId);
	int deleteUnselectedRecords(int userId);
	int deleteAllRecords();
}
