package com.service.VoiceSNS.controller;

import java.util.List;

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

	@Autowired
	private RecordService recordService;
	
	@PostMapping("/register")
	public Record createRecord(@RequestBody Record record) {
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
