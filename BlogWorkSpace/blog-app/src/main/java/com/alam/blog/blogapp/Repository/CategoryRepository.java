package com.alam.blog.blogapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alam.blog.blogapp.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long>{
	
	CategoryEntity findCategoryById(Long id);

}
