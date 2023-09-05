package com.cci.dto.request;

import com.cci.dto.UserInfoDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CreateUserRequest extends UserInfoDto {
	
	@JsonProperty("username")
	private String userName;

}
