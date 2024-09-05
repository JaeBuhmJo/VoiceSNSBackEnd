package com.service.VoiceSNS.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.VoiceSNS.service.RecordService;
import com.service.VoiceSNS.domain.Record;

@RestController
@RequestMapping("/record")
public class RecordController {

	private static final Logger logger = LoggerFactory.getLogger(RecordController.class);

	@Autowired
	private RecordService recordService;
	
	@PostMapping("/register")
	public Record createRecord(@RequestBody Record record) {
		// 로그 추가
        logger.info("createRecord 호출됨");
        logger.info("받은 Record: {}", record);
        logger.info("Content: {}", record.getContent());
        logger.info("Content 타입: {}", record.getContent().getClass().getName());
        
        return recordService.registerRecord(record);
    }
	
	@GetMapping("/{recordId}")
    public Record getRecord(@PathVariable int recordId) {
        return recordService.getRecord(recordId);
    }
	
	@GetMapping("/user/{userId}")
    public List<Record> getUserRecords(@PathVariable int userId) {
        return recordService.getUserRecords(userId);
    }
	
	@DeleteMapping("/user/{userId}/delete")
    public void deleteUnselectedRecords(@PathVariable int userId) {
        recordService.deleteUnselectedRecords(userId);
    }

}
