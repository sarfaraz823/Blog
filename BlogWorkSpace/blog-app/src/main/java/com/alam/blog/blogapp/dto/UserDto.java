package com.alam.blog.blogapp.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.alam.blog.blogapp.entity.UserEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

	Long id;
	String name;
	String status;
	List<String> fields = new ArrayList<String>();

	public static UserDto convertEntityToDto(UserEntity userEntity) {

		UserDto userDto = BeanUtils.instantiateClass(UserDto.class);
		BeanUtils.copyProperties(userEntity, userDto);
		return userDto;

	}

}
