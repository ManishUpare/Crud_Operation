package com.bikkadIt.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikkadIt.dtos.UserDto;
import com.bikkadIt.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	// create

	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser( @RequestBody UserDto userDto) {

		UserDto createUser = userService.createUser(userDto);

		return new ResponseEntity<UserDto>(createUser, HttpStatus.CREATED);

	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {

		UserDto updateUser = userService.updateUser(userDto, userId);

		return new ResponseEntity<UserDto>(updateUser, HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<UserDto>> getAll() {

		List<UserDto> all = userService.getAll();

		return new ResponseEntity<List<UserDto>>(all, HttpStatus.OK);

	}

	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable Integer userId) {

		UserDto user = userService.getUser(userId);

		return new ResponseEntity<UserDto>(user, HttpStatus.OK);

	}

	@GetMapping("/delete/{userId}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable Integer userId) {

		userService.deleteUser(userId);

		return new ResponseEntity<UserDto>(HttpStatus.OK);

	}

}
