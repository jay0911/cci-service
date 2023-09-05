package com.cci.service;

import java.util.List;

import com.cci.dto.UserInfoDto;
import com.cci.dto.request.CreateUserRequest;
import com.cci.dto.request.UpdateUserRequest;
import com.cci.dto.response.UserInfoResponse;
import com.cci.models.User;

public interface UserService {
	public UserInfoDto createUser(CreateUserRequest createUserRequest);
	public UserInfoDto updateUser(long id, UpdateUserRequest updateUserRequest);
	public List<UserInfoResponse> getUsers();
	public UserInfoResponse getUser(long id);
	public User findById(long id);
}
