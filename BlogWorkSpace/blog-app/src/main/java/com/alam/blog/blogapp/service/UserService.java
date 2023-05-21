package com.alam.blog.blogapp.service;

import java.util.List;

import com.alam.blog.blogapp.dto.UserDto;

public interface UserService {
	
	UserDto saveUser(UserDto userDto);
	
	UserDto getUserById(Long id);
	
	String deleteUser(Long id);
	
	List<UserDto> findAllUser(int pageNumber,int pageSize);

}
