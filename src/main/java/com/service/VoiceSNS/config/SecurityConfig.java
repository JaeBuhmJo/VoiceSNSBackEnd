package com.service.VoiceSNS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.service.VoiceSNS.filter.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
    @Bean
    JwtRequestFilter jwtRequestFilter() {
        return new JwtRequestFilter();
    }

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/**").permitAll() // security 권한 레벨은 활용하지 않으므로 모두 허용
	            .anyRequest().authenticated())
	        .sessionManagement(session -> session
	            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	        .addFilterBefore(jwtRequestFilter(), UsernamePasswordAuthenticationFilter.class); // 모든 요청은 jwtRequestFilter를 거친다

	    return http.build();
	}

}