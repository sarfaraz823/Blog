package com.alam.blog.blogapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alam.blog.blogapp.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{
	
	@Query("select u from UserEntity as u where u.id=:id")
	UserEntity fetchByUserId(Long id);

}
