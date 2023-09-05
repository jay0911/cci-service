package com.cci.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CreateUserTaskRequest {
	private String name;
	private String description;
	@JsonProperty("date_time")
	private String dateTime;
}
