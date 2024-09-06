package com.service.VoiceSNS.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Connection {
    private int connection_id;
    private int user1_id;
    private int user2_id;
    private Timestamp c_date;
    
	public Connection() {
		super();
	}

}


