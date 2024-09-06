package com.service.VoiceSNS;

import java.io.IOException;
import java.io.Reader;
import java.sql.Timestamp;
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

import com.service.VoiceSNS.domain.Connection;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ConnectUnitTest {
	
	static int user_id_one = 1;
	static int user_id_two = 5;
	
//    @Test
//    @Order(1)
//    public void insertFriendRequest() throws IOException{
//    	System.out.println("============== Connect Insert INSERT Test =============");
//    	Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
//		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
//		SqlSession session = factory.openSession();
//		
//		Map<String, Object> params = new HashMap<>();
//		params.put("user_id_one", user_id_one);
//		params.put("user_id_two", user_id_two);
//		
//		System.out.println(session.insert("ConnectMapper.insertConnect", params));
//		session.commit();
//    }
    
    
    @Test
    @Order(2)
    public void getConnectFriendRequest() throws IOException{
    	System.out.println("============== Connect READ Test =============");
    	Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		Map<String, Object> params = new HashMap<>();
		params.put("user_id_one", user_id_one);
		params.put("user_id_two", user_id_two);
		HashMap connect = session.selectOne("ConnectMapper.getConnect", params);
		
		System.out.println(connect);
		session.commit();
    }
    
    @Test
    @Order(3)
    public void getConnectsTest() throws IOException{
    	System.out.println("============== Connectss READ Test =============");
    	Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		
		List<HashMap> connect = session.selectList("ConnectMapper.getConnects", 1);
		
		System.out.println(connect);
		session.commit();
    }
    
    
    
}