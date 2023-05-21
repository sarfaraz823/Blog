package com.alam.blog.blogapp.dto;

import org.springframework.beans.BeanUtils;

import com.alam.blog.blogapp.entity.PostEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
	Long id;
	String title;
	String content;
	UserDto userDto;
	CategoryDto categoryDto;

	public static PostDto convertEntityToDto(PostEntity postEntity) {
		PostDto postDto = BeanUtils.instantiateClass(PostDto.class);
		BeanUtils.copyProperties(postEntity, postDto);
		
		UserDto userDto=UserDto.convertEntityToDto(postEntity.getUserEntity());
		postDto.setUserDto(userDto);
		
		CategoryDto categoryDto=CategoryDto.convertEntityToDto(postEntity.getCategoryEntity());
		postDto.setCategoryDto(categoryDto);
		
		return postDto;
		
	}
}
