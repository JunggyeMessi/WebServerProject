package com.webserverproject.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webserverproject.blog.dto.ResponseDto;
import com.webserverproject.blog.model.User;
import com.webserverproject.blog.service.UserService;

@RestController 
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController : save 호출됨");
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	/*
	 * @PutMapping("/user") public ResponseDto<Integer> update(@RequestBody User
	 * user) { // key=value, x-www-form-urlencoded userService.회원수정(user);
	 * 
	 * Authentication authentication = AuthenticationManager.authenticate(new
	 * UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	 * SecurityContextHolder.getContext().setAuthentication(authentication);
	 * 
	 * return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); }
	 */
	
	
}
