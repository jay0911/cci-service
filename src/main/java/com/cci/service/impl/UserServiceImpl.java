package com.cci.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cci.dto.UserInfoDto;
import com.cci.dto.request.CreateUserRequest;
import com.cci.dto.request.UpdateUserRequest;
import com.cci.dto.response.UserInfoResponse;
import com.cci.exceptions.UserException;
import com.cci.models.User;
import com.cci.repository.UserRepository;
import com.cci.service.UserService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Override
	@Transactional
	public UserInfoDto createUser(CreateUserRequest createUserRequest) {
		User user = new User();
		user.setUserName(createUserRequest.getUserName());
		user.setFirstName(createUserRequest.getFirstName());
		user.setLastName(createUserRequest.getLastName());
		
		return new UserInfoResponse().build(userRepository.save(user));
	}

	@Override
	@Transactional
	public UserInfoDto updateUser(long id,UpdateUserRequest updateUserRequest) {
		User user = findById(id);
		user.setFirstName(updateUserRequest.getFirstName());
		user.setLastName(updateUserRequest.getLastName());
		
		return new UserInfoResponse().build(userRepository.save(user));
	}

	@Override
	public List<UserInfoResponse> getUsers() {
		return userRepository
				.findAll()
				.stream()
				.map(user-> new UserInfoResponse().build(user))
				.collect(Collectors.toList());
	}

	@Override
	public UserInfoResponse getUser(long id) {
		User user = findById(id);
		return new UserInfoResponse().build(user);
	}
	
	public User findById(long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserException("user id not found "+id));
	}
}
