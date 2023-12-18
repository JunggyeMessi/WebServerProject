package com.webserverproject.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
   SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.csrf(AbstractHttpConfigurer::disable);
      
      http.authorizeHttpRequests(authorize -> authorize
      			.requestMatchers(new AntPathRequestMatcher("/"),
      					new AntPathRequestMatcher("/auth/**"),
      					new AntPathRequestMatcher("/js/**"),
      					new AntPathRequestMatcher("/css/**"),
						new AntPathRequestMatcher("/image/**"),
						new AntPathRequestMatcher("/WEB-INF/views/**"))
      			.permitAll()
      			.anyRequest()
      			.authenticated()
      	);
      
      http.formLogin((formLogin) -> formLogin
      			.loginPage("/auth/loginForm")
      			.loginProcessingUrl("/auth/loginProc")
      			.defaultSuccessUrl("/"));
            
      return http.build();
   }

}