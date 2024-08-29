package com.service.VoiceSNS;

import java.io.IOException;
import java.io.Reader;
import java.sql.Time;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.VoiceSNS.domain.User;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class VoiceSnsBackEndApplicationTests {
	
	static int userId = 1;
	String email = "a09112@b.c";
	String password = "456";
	
	@Test
	@Order(1)
	void insertUser() throws IOException {
		System.out.println("============insertUser Test=============");
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		byte[] arr = {(byte) 01010};
		User user = new User(email, "123", "hi", arr , false, new Time(100000000), false, false);
		System.out.println(user);
		System.out.println(session.insert("UserMapper.insertUser", user));
		session.commit();
		
		// 다음 항목들 테스트를 위해 Id를 insertUser의 userId로 세팅
		user = session.selectOne("UserMapper.getUserInfo", user);
		System.out.println(user);
		userId = user.getUserId();
	}
	
	@Test
	@Order(2)
	void updateUser() throws IOException{
		System.out.println("============updateUser Test=============");
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		byte[] arr = {(byte) 01010};
		User user = new User(userId, email, password, "hello", arr , true, new Time(10000000), true, true);
		System.out.print(session.update("UserMapper.updateUserPassword", user));
		System.out.print(session.update("UserMapper.updateUserNickname", user));
		System.out.print(session.update("UserMapper.updateUserProfilePicture", user));
		System.out.print(session.update("UserMapper.updateUserAlarmOn", user));
		System.out.print(session.update("UserMapper.updateUserAlarmTime", user));
		System.out.print(session.update("UserMapper.updateUserGoogle", user));
		System.out.println(session.update("UserMapper.updateUserKakao", user));
		session.commit();
		System.out.println(user);
	}
	
	@Test
	@Order(3)
	void findUser() throws IOException{
		System.out.println("============findUser Test=============");
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		User user = session.selectOne("UserMapper.findUser", userId);
		System.out.println(user);
	}
	
	@Test
	@Order(4)
	void getUserInfo() throws IOException{
		System.out.println("============getUserInfo Test=============");
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user = session.selectOne("UserMapper.getUserInfo", user);
		System.out.println(user);
	}
	
	@Test
	@Order(5)
	void deleteUser() throws IOException {
		System.out.println("============deleteUser Test=============");
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		System.out.println(session.delete("UserMapper.deleteUser", userId));
		session.commit();
	}
	


}
