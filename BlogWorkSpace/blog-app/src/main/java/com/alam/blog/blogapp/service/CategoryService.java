package com.alam.blog.blogapp.service;

import com.alam.blog.blogapp.dto.CategoryDto;

public interface CategoryService {
	
	CategoryDto saveCategory(CategoryDto categoryDto);
	CategoryDto fetchCategoryById(Long categoryId);
	String deleteCategory(Long id);

}
