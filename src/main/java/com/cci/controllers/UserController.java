package com.cci.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cci.constants.UriConstants;
import com.cci.dto.request.CreateUserRequest;
import com.cci.dto.request.UpdateUserRequest;
import com.cci.dto.response.UserInfoResponse;
import com.cci.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(UriConstants.USER_API)
@AllArgsConstructor
@Slf4j
public class UserController {
	
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest){
		log.info("Creating user ...");
		return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.createUser(createUserRequest));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UpdateUserRequest updateUserRequest){
		log.info("Updating user ...");
		return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.updateUser(id, updateUserRequest));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserInfoResponse> getUser(@PathVariable("id") long id){
		log.info("Selecting user ...");
		return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUser(id));
	}
	
	@GetMapping()
	public ResponseEntity<List<UserInfoResponse>> getUsers(){
		log.info("Selecting users ...");
		return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getUsers());
	}
}
