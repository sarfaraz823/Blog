package com.alam.blog.blogapp.service;

import java.util.List;

import com.alam.blog.blogapp.dto.PostDto;
import com.alam.blog.blogapp.response.ResponseDemo;

public interface PostService {

	PostDto savePost(PostDto postDto,Long userId,Long categoryId);
	PostDto getPostById(Long id);
	String  deletePost(Long id);
	//List<PostDto> findAllPost();
	List<ResponseDemo> findAllPost();
}
