package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurity {

	@Bean
	public InMemoryUserDetailsManager userManagerDetails() {
		UserDetails abc = User.builder().username("abc").password("{noop}test1").roles("EMPLOYEE").build();
		UserDetails pqr = User.builder().username("pqr").password("{noop}test2").roles("EMPLOYEE","MANAGER").build();
		UserDetails xyz = User.builder().username("xyz").password("{noop}test3").roles("EMPLOYEE","MANAGER","ADMIN").build();
		
		return new InMemoryUserDetailsManager(abc, pqr, xyz);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(configurer ->
		
				configurer
				.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
				);
		
		http.httpBasic();
		
		http.csrf().disable();
		
		return http.build();
	}
}
