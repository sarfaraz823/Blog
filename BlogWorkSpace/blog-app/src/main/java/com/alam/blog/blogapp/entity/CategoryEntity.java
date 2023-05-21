package com.alam.blog.blogapp.entity;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.alam.blog.blogapp.dto.CategoryDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category")
public class CategoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categoryId")
	private Long id;
	private String categoryTitle;
	private String categoryDesc;
	
	@OneToMany(mappedBy="categoryEntity",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<PostEntity> postEntity;

	public static CategoryEntity convertDtoToEntity(CategoryDto categoryDto) {
		CategoryEntity categoryEntity = BeanUtils.instantiateClass(CategoryEntity.class);
		BeanUtils.copyProperties(categoryDto, categoryEntity);
		return categoryEntity;
		
	}
}
