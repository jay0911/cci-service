package com.cci.dto.response;

import com.cci.dto.UserInfoDto;
import com.cci.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserInfoResponse extends UserInfoDto {
	private long id;
	@JsonProperty("username")
	private String userName; 
	
	public UserInfoResponse build(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.id = user.getId();
		this.userName = user.getUserName();
		return this;
	}
}
