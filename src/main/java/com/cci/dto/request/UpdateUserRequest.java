package com.cci.dto.request;

import com.cci.dto.UserInfoDto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UpdateUserRequest extends UserInfoDto {

}
