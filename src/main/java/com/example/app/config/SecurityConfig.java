
package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//설정클래스라는 뜻
@Configuration
public class SecurityConfig {

    //요청이 컨트롤러에 도착하기 전에 필터 체인을 거치게 합니다. 이 필터들이 인증과 인가를 검사합니다.
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/members/signup", "/login",
                                "/css/**", "/js/**").permitAll()
                        //위에서 지정한 경로를 제외한 모든 요청은 거부
                        .anyRequest().authenticated()
                )
                //폼로그인 활성화
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}
