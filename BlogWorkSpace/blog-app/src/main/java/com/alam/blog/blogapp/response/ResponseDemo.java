package com.alam.blog.blogapp.response;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alam.blog.blogapp.Repository.PostRepository;
import com.alam.blog.blogapp.dto.CategoryDto;
import com.alam.blog.blogapp.dto.PostDto;
import com.alam.blog.blogapp.dto.UserDto;
import com.alam.blog.blogapp.entity.PostEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDemo extends PostDto {

	DemoList demoList;
	String form;
	
	public static ResponseDemo convertEntityToDto(PostEntity postEntity) {
		ResponseDemo RpostDto = BeanUtils.instantiateClass(ResponseDemo.class);
		BeanUtils.copyProperties(postEntity, RpostDto);

		UserDto userDto = UserDto.convertEntityToDto(postEntity.getUserEntity());
		RpostDto.setUserDto(userDto);

		CategoryDto categoryDto = CategoryDto.convertEntityToDto(postEntity.getCategoryEntity());
		RpostDto.setCategoryDto(categoryDto);

		return RpostDto;

	}

}
