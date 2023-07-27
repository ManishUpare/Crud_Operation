package com.bikkadIt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadIt.dtos.UserDto;
import com.bikkadIt.entities.User;
import com.bikkadIt.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto createUser(UserDto userDto) {

//		String id = UUID.randomUUID().toString();
//		userDto.setUserId(id);

		User user = mapper.map(userDto, User.class);

		User save = userRepository.save(user);

		return mapper.map(save, UserDto.class);

	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {

		User user = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("user not found with {}" + userId));

		user.setUserName(userDto.getUserName());
		user.setAddress(userDto.getAddress());
		user.setCompanyName(userDto.getCompanyName());
		user.setPassword(userDto.getPassword());

		User saveUser = userRepository.save(user);

		return mapper.map(saveUser, UserDto.class);

	}

	@Override
	public List<UserDto> getAll() {

		List<User> all = userRepository.findAll();

		List<UserDto> list = all.stream().map((m) -> mapper.map(m, UserDto.class)).collect(Collectors.toList());

		return list;
	}

	@Override
	public UserDto getUser(Integer userId) {
		
		User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Not Founf With ID {} "+userId));
		
		UserDto dto=mapper.map(user, UserDto.class);
		
		return dto;
	}

	@Override
	public void deleteUser(Integer userId) {

		User user=userRepository.findById(userId).orElseThrow(()->new RuntimeException());
	
		userRepository.delete(user);
	}

}
