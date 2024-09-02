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

        final String authorizationHeader = request.getHeader("Authorization");
        final String refreshToken = request.getHeader("Refresh-Token");
        String path = request.getRequestURI();

        // 회원가입과 로그인 요청은 필터를 통과
        if ("/user".equals(path) || "/auth/login".equals(path)) {
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
                    // 필요한 경우 여기에서 인증 정보를 설정할 수 있습니다.
                } else {
                	// JWT가 유효하지 않은 경우 리프레시 토큰 검사
                    if (refreshToken != null && jwtUtil.validateToken(refreshToken)) {
                        // 리프레시 토큰이 유효하면 새로운 JWT 발급
                        String username = jwtUtil.extractUsername(refreshToken);
                        String newJwt = jwtUtil.generateToken(username);
                        
                        // 새로운 JWT를 응답 헤더에 추가
                        response.setHeader("Authorization", "Bearer " + newJwt);
                    } else {
                        response.sendRedirect("/login"); // 로그인 페이지로 리다이렉트
                        return; // 요청 중지
                    }
                }
            } catch (Exception e) {
                response.sendRedirect("/login"); // 예외 발생 시 로그인 페이지로 리다이렉트
                return; // 요청 중지
            }
        } else {
            response.sendRedirect("/login"); // Authorization 헤더가 없거나 형식이 잘못된 경우 로그인 페이지로 리다이렉트
            return; // 요청 중지
        }

        chain.doFilter(request, response);
    }
}