package com.cci.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cci.models.Task;
import com.cci.models.Task.Status;
import com.cci.repository.TaskRepository;
import com.cci.service.UserTaskSchedulerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class UserTaskSchedulerServiceImpl implements UserTaskSchedulerService {

	private TaskRepository taskRepository;
	
	@Override
	public void updateTaskStatus() {
		List<Task> tasks =  taskRepository.findByStatusAndDateTimeLessThan(Status.pending, LocalDateTime.now());
		
		for(Task task:tasks) {
			log.info("tasks pending id: {} status: {} date: {}",task.getId(),task.getStatus(),task.getDateTime());
			task.setStatus(Status.done);
			taskRepository.saveAndFlush(task);
		}
	}

}
