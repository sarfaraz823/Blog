package com.alam.blog.blogapp.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alam.blog.blogapp.Repository.CategoryRepository;
import com.alam.blog.blogapp.dto.CategoryDto;
import com.alam.blog.blogapp.entity.CategoryEntity;
import com.alam.blog.blogapp.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) {
		CategoryEntity categoryEntity = CategoryEntity.convertDtoToEntity(categoryDto);
		CategoryEntity categoryEntityRes = categoryRepository.save(categoryEntity);
		CategoryDto categoryDtores = CategoryDto.convertEntityToDto(categoryEntityRes);
		return categoryDtores;
	}

	@Override
	public CategoryDto fetchCategoryById(Long categoryId) {
		Optional<CategoryEntity> categoryEntityOpt=categoryRepository.findById(categoryId);
		CategoryEntity CategoryEntityRes=categoryEntityOpt.get();
		CategoryDto categoryDtores = CategoryDto.convertEntityToDto(CategoryEntityRes);
		return categoryDtores;
	}

	@Override
	public String deleteCategory(Long id) {
	CategoryEntity categoryEntity=categoryRepository.findCategoryById(id);
		categoryRepository.delete(categoryEntity);
		return "Category Deleted Successfully";
	}

}
