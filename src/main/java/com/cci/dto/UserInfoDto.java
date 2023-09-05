package com.cci.dto;

import com.cci.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserInfoDto {
	@JsonProperty("first_name")
	protected String firstName;
	@JsonProperty("last_name")
	protected String lastName;
	
	public UserInfoDto build(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		
		return this;
	}
}
