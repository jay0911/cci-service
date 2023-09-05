package com.cci.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.cci.models.Task;
import com.cci.models.Task.Status;
import com.cci.models.User;

public interface TaskRepository extends DomainRepository<Task, Long> {
	Optional<Task> findByUserAndId(User user, long id);
	
	List<Task> findByStatusAndDateTimeLessThan(Status status, LocalDateTime localDateTime);
}
