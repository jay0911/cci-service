package com.cci.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cci.dto.request.CreateUserTaskRequest;
import com.cci.dto.request.UpdateUserTaskRequest;
import com.cci.dto.response.UserTaskInfoResponse;
import com.cci.exceptions.UserException;
import com.cci.models.Task;
import com.cci.models.User;
import com.cci.models.Task.Status;
import com.cci.repository.TaskRepository;
import com.cci.service.UserService;
import com.cci.service.UserTaskService;
import com.cci.utils.DateUtils;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserTaskServiceImpl implements UserTaskService {
	
	private TaskRepository taskRepository;
	
	private UserService userService;

	@Override
	@Transactional
	public UserTaskInfoResponse createTask(long userId, CreateUserTaskRequest createUserTaskRequest) {
		User user = userService.findById(userId);
		Task task = new Task();
		task.setUser(user);
		task.setDateTime(DateUtils.getLocalDateTime(createUserTaskRequest.getDateTime()));
		task.setDescription(createUserTaskRequest.getDescription());
		task.setName(createUserTaskRequest.getName());
		task.setStatus(Status.pending);
		return new UserTaskInfoResponse().build(taskRepository.save(task));
	}


	@Override
	@Transactional
	public UserTaskInfoResponse updateTask(long userId, long taskId, UpdateUserTaskRequest updateUserTaskRequest) {
		User user = userService.findById(userId);
		Task task = taskRepository.findByUserAndId(user, taskId).orElseThrow(() -> new UserException("task id not found "+taskId));
		task.setName(updateUserTaskRequest.getName());
		return new UserTaskInfoResponse().build(taskRepository.save(task));
	}

	@Override
	@Transactional
	public boolean deleteTask(long userId, long taskId) {
		User user = userService.findById(userId);
		Task task = taskRepository.findByUserAndId(user, taskId).orElseThrow(() -> new UserException("task id not found "+taskId));
		return taskRepository.softDelete(task) > 0;
	}


	@Override
	public UserTaskInfoResponse getUserTask(long userId, long taskId) {
		User user = userService.findById(userId);
		Task task = taskRepository.findByUserAndId(user, taskId).orElseThrow(() -> new UserException("task id not found "+taskId));
		return new UserTaskInfoResponse().build(task);
	}


	@Override
	public List<UserTaskInfoResponse> getAllUserTask(long userId) {
		User user = userService.findById(userId);
		
		return user.getTasks().stream().map(task->{
			return new UserTaskInfoResponse().build(task);
		}).collect(Collectors.toList());
		
	}

}
