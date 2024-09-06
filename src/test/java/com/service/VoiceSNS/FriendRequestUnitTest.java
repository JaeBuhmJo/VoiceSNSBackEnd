package com.service.VoiceSNS;

import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.VoiceSNS.domain.FriendRequest;
import com.service.VoiceSNS.domain.Record;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FriendRequestUnitTest {
	
	static int senderId = 1;
	static int receiverId = 3;
	
    @Test
    @Order(1)
    public void insertFriendRequest() throws IOException{
    	System.out.println("============== FriendRequest INSERT Test =============");
    	Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		
		FriendRequest friendRequest = new FriendRequest();
		friendRequest.setReceiverId(receiverId);
		friendRequest.setSenderId(senderId);
		
		
		System.out.println(friendRequest);
		System.out.println(session.insert("FriendRequestMapper.insertfriendRequest", friendRequest));
		session.commit();
    }
    
    @Test
    @Order(2)
    public void getFriendRequestById() throws IOException{
    	System.out.println("============== getFriendRequestById Test =============");
    	Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		FriendRequest friendRequest = new FriendRequest();
		friendRequest = session.selectOne("FriendRequestMapper.getFriendRequest", receiverId);
		
		System.out.println(friendRequest);
		session.commit();
    }
    
    @Test
    @Order(3)
    public void updateFriendRequestStatus() throws IOException{
    	System.out.println("============== getFriendRequestById Test =============");
    	Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
        Map<String, Object> params = new HashMap<>();
        params.put("requestId", 1); // 업데이트할 요청 ID
        params.put("status", "accepted"); // 새 상태
		
		
		System.out.println(session.update("FriendRequestMapper.updateFriendRequestStatus",params));
		session.commit();
    }
    

    

    
}