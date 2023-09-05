package com.cci.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cci.constants.UriConstants;
import com.cci.dto.request.CreateUserTaskRequest;
import com.cci.dto.request.UpdateUserTaskRequest;
import com.cci.service.UserTaskService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(UriConstants.USER_API)
@AllArgsConstructor
@Slf4j
public class UserTaskController {
	
	private UserTaskService userTaskService;

	@PostMapping("/{id}/task")
	public ResponseEntity<?> createTask(@PathVariable("id") long id,@RequestBody CreateUserTaskRequest createUserTaskRequest){
		log.info("Creating user tasks...");
		return ResponseEntity
                .status(HttpStatus.OK)
                .body(userTaskService.createTask(id, createUserTaskRequest));
	}
	
	@PutMapping("/{user_id}/task/{task_id}")
	public ResponseEntity<?> createTask(@PathVariable("user_id") long userId,@PathVariable("task_id") long taskId,@RequestBody UpdateUserTaskRequest updateUserTaskRequest){
		log.info("Updating user tasks...");
		return ResponseEntity
                .status(HttpStatus.OK)
                .body(userTaskService.updateTask(userId, taskId, updateUserTaskRequest));
	}
	
	@DeleteMapping("/{user_id}/task/{task_id}")
	public ResponseEntity<?> deleteTask(@PathVariable("user_id") long userId,@PathVariable("task_id") long taskId){
		log.info("Deleting user tasks...");
		return ResponseEntity
                .status(HttpStatus.OK)
                .body(userTaskService.deleteTask(userId, taskId));
	}
	
	@GetMapping("/{user_id}/task/{task_id}")
	public ResponseEntity<?> getUserTask(@PathVariable("user_id") long userId,@PathVariable("task_id") long taskId){
		log.info("getting user tasks...");
		return ResponseEntity
                .status(HttpStatus.OK)
                .body(userTaskService.getUserTask(userId, taskId));
	}
	
	
	@GetMapping("/{user_id}/task")
	public ResponseEntity<?> getAllUserTask(@PathVariable("user_id") long userId){
		log.info("getting user all tasks...");
		return ResponseEntity
                .status(HttpStatus.OK)
                .body(userTaskService.getAllUserTask(userId));
	}
}
