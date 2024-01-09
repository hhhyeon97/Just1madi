package com.haza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	 @Bean
	    public CustomAuthenticationProvider customAuthenticationProvider() {
	        return new CustomAuthenticationProvider();
	    }
	 
	 
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable();
	        http.authorizeHttpRequests()
	        		.requestMatchers("/memo/**").authenticated()
	                .requestMatchers("/admin/**").hasRole("ADMIN")
	                .anyRequest().permitAll()
	        		.and()
	        		.formLogin()
	        		.loginPage("/login")
	        		.loginProcessingUrl("/login_ok")
	        		 .usernameParameter("username")    // 사용자를 찾기 위해 사용할 매개변수
	                 .passwordParameter("password")
	        		.failureUrl("/login?error=true")
	        		.defaultSuccessUrl("/memo/list")
	        		//.successHandler(new CustomAuthenticationSuccessHandler())  // CustomAuthenticationSuccessHandler 인스턴스 직접 생성
	        		.permitAll()
	        		.and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID");
	        
	        

	        // 문자열 인코딩 설정 추가
	        http
	            .headers()
	                .frameOptions().disable()
	                .and()
	            .formLogin()
	                .defaultSuccessUrl("/memo/list", true)
	                .and()
	            .logout()
	                .permitAll();

	        
	        
	        return http.build();
	    }

	
}
