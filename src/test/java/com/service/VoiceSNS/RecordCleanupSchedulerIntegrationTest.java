/**
 * 작성자 : 정해슬 
 * 설명 : 녹음 자동삭제 스케줄러 테스팅 
 * ---------------------------------
 * 수정자       수정일         수정 내용
 * ---------------------------------
 * 정해슬     8:28 22:00     오류 해결중..
 * 정해슬     8:29 17:00     CRUD 테스트 완료 
 */

package com.service.VoiceSNS;

import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.VoiceSNS.domain.Record;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RecordCleanupSchedulerIntegrationTest {
	
	static int userId = 1;
	static int recordId = 1;
	
    @Test
    @Order(1)
    public void insertRecord() throws IOException{
    	System.out.println("============== insertRecord Test =============");
    	Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		byte[] content = new byte[] {1, 2, 3};
		
		Record record = new Record(currentTime, content, userId);
		System.out.println(session.insert("RecordMapper.insertRecord", record));
		System.out.println(record);
		session.commit();
    }
    
    @Test
    @Order(2)
    public void getRecord() throws IOException {
    	System.out.println("\n============== getRecord Test =============");
    	Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Record record = new Record();
		record = session.selectOne("RecordMapper.getRecord", 4);
		System.out.println(record);
    }
    
    @Test
    @Order(3)
    public void deleteUnselectedRecords() throws IOException {
    	System.out.println("\n============== deleteUnselectedRecords Test =============");
    	Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
    	SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
    	SqlSession session = factory.openSession();
    	
    	System.out.println(session.delete("RecordMapper.deleteUnselectedRecords", userId));
    	session.commit();
    }    
    
}