package com.haza.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.Filter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	 @Bean
	    public CustomAuthenticationFailureHandler customAuthenticationFailureHandler() {
	        return new CustomAuthenticationFailureHandler();
	    }

	/* 
	 @Bean
	    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
	        CustomAuthenticationFilter filter = new CustomAuthenticationFilter(authenticationManagerBean());
	        filter.setAuthenticationSuccessHandler(new CustomAuthenticationSuccessHandler());
	        filter.setAuthenticationFailureHandler(new CustomAuthenticationFailureHandler());
	        return filter;
	    }
*/
	    
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable();
	       // http.addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	        http.authorizeHttpRequests()
	                .requestMatchers("/memo/**").authenticated() 
	                .requestMatchers("/admin/**").hasRole("ADMIN")
	                .anyRequest().permitAll()
	        		.and()
	        		.formLogin()
	        		.loginPage("/")
	        		.loginProcessingUrl("/loginCheck")
	        		.defaultSuccessUrl("/memo/list")
	        		.failureHandler(customAuthenticationFailureHandler()) // 실패 핸들러 등록
	                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID");
	        return http.build();
	    }

	//private Filter customAuthenticationFilter() {
		// TODO Auto-generated method stub
		//return null;
	//}
	 
	
}
