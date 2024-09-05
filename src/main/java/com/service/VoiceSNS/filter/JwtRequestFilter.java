package com.service.VoiceSNS.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.service.VoiceSNS.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
    	
    	System.out.println("JwtRequestFilter Called");

        final String authorizationHeader = request.getHeader("Authorization");
        String path = request.getRequestURI();
        
        System.out.println("Filter request " + path + " " + request.getMethod());
        
        // 다음의 요청들은 jwt 필터 검사를 하지 않음
        if (("/user".equals(path) && "POST".equals(request.getMethod())) // 회원가입
    		|| "/auth/login".equals(path) // 로그인
    		|| "/auth/refresh".equals(path) && "POST".equals(request.getMethod()) // access 재발급 요청 
        	) {
            chain.doFilter(request, response);
            return;
        }

        System.out.println("JWT Filter Activated");

        // Bearer [token] 형식에서 토큰 추출
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
        	final String jwt = authorizationHeader.substring(7);
            try {
                // JWT 유효성 검사
                if (jwtUtil.validateToken(jwt)) {
                    // 토큰 유효한 경우 userEmail을 request에 추가
                	System.out.println("액세스 토큰 유효");
                	request.setAttribute("userEmail", jwtUtil.extractUsername(jwt));
                }
            } catch (Exception e) {
            	e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Access not valid");
                return; // 요청 중지
            }
        } else {
        	// Authorization 헤더가 없거나 형식이 잘못된 경우 로그인 페이지로 리다이렉트
        	System.out.println("토큰 헤더가 없음");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Unauthorized");
            return; // 요청 중지
        }

        chain.doFilter(request, response);
    }
}