package com.alam.blog.blogapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alam.blog.blogapp.Repository.UserRepository;
import com.alam.blog.blogapp.dto.UserDto;
import com.alam.blog.blogapp.entity.UserEntity;
import com.alam.blog.blogapp.exception.CustomValidationException;
import com.alam.blog.blogapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto saveUser(UserDto userDto) {

		UserEntity userEntity = UserEntity.convertDtoToEntity(userDto);

		UserEntity userEntityRes = userRepository.save(userEntity);

		UserDto userDtoRes = UserDto.convertEntityToDto(userEntityRes);

		return userDtoRes;
	}

	@Override
	public UserDto getUserById(Long id) {

		Optional<UserEntity> userEntity = userRepository.findById(id);
		if (userEntity.isEmpty()) {
			throw new CustomValidationException("User Id Not found with id ");
		} else {
			UserEntity userEntityOpt = userEntity.get();
			UserDto userDto = UserDto.convertEntityToDto(userEntityOpt);
			return userDto;
		}

	}

	@Override
	public String deleteUser(Long id) {
		UserEntity userEntity=userRepository.fetchByUserId(id);
		userRepository.delete(userEntity);
		return "User deleted successfully";
	}

	@Override
	public List<UserDto> findAllUser(int pageNumber, int pageSize) {
		Pageable p=PageRequest.of(pageNumber, pageSize);
		Page<UserEntity> allUser=userRepository.findAll(p);
		List<UserEntity> allUserRes=allUser.getContent();
		return allUserRes.stream().map(UserDto::convertEntityToDto).collect(Collectors.toList());
	}

}
