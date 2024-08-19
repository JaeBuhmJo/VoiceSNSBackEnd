package com.service.VoiceSNS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// DB연결 완료 후, 회원제 구축 완료 후 exclude 하나씩 빼야함
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
public class VoiceSnsBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoiceSnsBackEndApplication.class, args);
	}

}
