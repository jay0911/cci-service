package com.cci.dto.response;

import java.time.LocalDateTime;

import com.cci.models.Task;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserTaskInfoResponse {
	private long id;
	private String name;
	private String description;
	@JsonProperty("date_time")
	private LocalDateTime dateTime;
	private Task.Status status;
	
	public UserTaskInfoResponse build(Task task) {
		this.id = task.getId();
		this.name = task.getName();
		this.description = task.getDescription();
		this.dateTime = task.getDateTime();
		this.status = task.getStatus();
		return this;
	}
}
