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
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable();
	        http.authorizeHttpRequests()
	                .requestMatchers("/memo/**").authenticated() 
	                .requestMatchers("/admin/**").hasRole("ADMIN")
	                .anyRequest().permitAll()
	        		.and()
	        		.formLogin()
	        		.loginPage("/")
	        		.loginProcessingUrl("/login_ok")
	        		.defaultSuccessUrl("/memo/list");
	        		return http.build();
	    }
}
