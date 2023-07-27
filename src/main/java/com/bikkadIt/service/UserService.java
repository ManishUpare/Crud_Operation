package com.bikkadIt.service;

import java.awt.print.Pageable;
import java.util.List;

import com.bikkadIt.dtos.UserDto;

public interface UserService {

	//create
	
	UserDto createUser(UserDto userDto);
	
	//update
	
	UserDto updateUser(UserDto userDto,Integer userId);
	
	//get single
	
	UserDto getUser(Integer userId);
	
	//get All
	
	List<UserDto> getAll();
	
	//delete
	
	void deleteUser(Integer userId);
}
