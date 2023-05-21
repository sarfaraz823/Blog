package com.alam.blog.blogapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alam.blog.blogapp.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity,Long>{
	
	PostEntity findPostById(Long id);
	
	@Query("select title t from PostEntity where id=:id")
	String findTitleByid(Long id);

}
