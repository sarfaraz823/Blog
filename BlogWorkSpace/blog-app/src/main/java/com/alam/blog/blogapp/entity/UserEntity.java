package com.alam.blog.blogapp.entity;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.alam.blog.blogapp.dto.UserDto;

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
@Table(name="users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	@Column(name="username")
	String name;
	String status;
	
	@OneToMany(mappedBy="userEntity",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	List<PostEntity> postEntity;
	
	public static UserEntity convertDtoToEntity(UserDto userDto) {
		
		UserEntity userEntity = BeanUtils.instantiateClass(UserEntity.class);
		BeanUtils.copyProperties(userDto, userEntity);
		
		return userEntity;
	}
	
	

}
