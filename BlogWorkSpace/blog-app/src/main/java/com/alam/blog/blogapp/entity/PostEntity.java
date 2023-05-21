package com.alam.blog.blogapp.entity;

import org.springframework.beans.BeanUtils;

import com.alam.blog.blogapp.dto.CategoryDto;
import com.alam.blog.blogapp.dto.PostDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name="Posts")
public class PostEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String title;
	
	@Column(nullable=false)
	String content;
	
	@ManyToOne
	@JoinColumn(name="userid")
	UserEntity userEntity;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	CategoryEntity categoryEntity;
	
	public static PostEntity convertDtoToEntity(PostDto postDto) {
		PostEntity postEntity = BeanUtils.instantiateClass(PostEntity.class);
		BeanUtils.copyProperties(postDto, postEntity);
		return postEntity;
		
	}

}
