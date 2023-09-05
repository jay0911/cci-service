package com.cci.service;

import java.util.List;

import com.cci.dto.request.CreateUserTaskRequest;
import com.cci.dto.request.UpdateUserTaskRequest;
import com.cci.dto.response.UserTaskInfoResponse;

public interface UserTaskService {
	public UserTaskInfoResponse createTask(long userId, CreateUserTaskRequest createUserTaskRequest);
	public UserTaskInfoResponse updateTask(long userId, long taskId, UpdateUserTaskRequest updateUserTaskRequest);
	public boolean deleteTask(long userId, long taskId);
	public UserTaskInfoResponse getUserTask(long userId, long taskId);
	public List<UserTaskInfoResponse> getAllUserTask(long userId);
}
