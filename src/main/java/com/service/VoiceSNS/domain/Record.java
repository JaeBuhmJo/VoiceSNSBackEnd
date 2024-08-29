package com.service.VoiceSNS.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Record {
	private int recordId;
	private Timestamp rDate;
	private byte[] content;
	private int userId;

	// 생성자 
	public Record() {
		super();
	}
	
	// AUTO_INCREMENT인 recordID 제외 record 생성
	public Record(Timestamp rDate, byte[] content, int userId) {
		super();
		this.rDate = rDate;
		this.content = content;
		this.userId = userId;
	}

}
