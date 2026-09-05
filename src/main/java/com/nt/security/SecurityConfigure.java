package com.nt.security;

import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties.Apiversion.Use;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfigure 
{
	@Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/home").authenticated()
				.anyRequest().permitAll())
		.formLogin(form -> form 
				.defaultSuccessUrl("/home",true)
				.permitAll());
		
		
		return http.build();
		
	}
	@Bean
	 InMemoryUserDetailsManager userServiceDeatils()
	{
		UserDetails user=User.builder()
				.username("Leela")
				.password("{noop}123")
				.roles("user")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
	
	
}
