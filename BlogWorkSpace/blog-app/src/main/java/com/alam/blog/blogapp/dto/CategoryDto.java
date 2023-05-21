package com.alam.blog.blogapp.dto;

import org.springframework.beans.BeanUtils;

import com.alam.blog.blogapp.entity.CategoryEntity;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class CategoryDto {
	
	Long id;
	String categoryDesc;
	String categoryTitle;
	public static CategoryDto convertEntityToDto(CategoryEntity categoryEntity) {
		CategoryDto categoryDto = BeanUtils.instantiateClass(CategoryDto.class);
		BeanUtils.copyProperties(categoryEntity, categoryDto);
		return categoryDto;
		
	}

}
