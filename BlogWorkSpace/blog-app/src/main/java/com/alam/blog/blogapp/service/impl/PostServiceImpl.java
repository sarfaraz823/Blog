package com.alam.blog.blogapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alam.blog.blogapp.Repository.CategoryRepository;
import com.alam.blog.blogapp.Repository.PostRepository;
import com.alam.blog.blogapp.Repository.UserRepository;
import com.alam.blog.blogapp.dto.PostDto;
import com.alam.blog.blogapp.entity.CategoryEntity;
import com.alam.blog.blogapp.entity.PostEntity;
import com.alam.blog.blogapp.entity.UserEntity;
import com.alam.blog.blogapp.response.DemoList;
import com.alam.blog.blogapp.response.ResponseDemo;
import com.alam.blog.blogapp.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository postRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public PostDto savePost(PostDto postDto, Long userId, Long categoryId) {

		Optional<UserEntity> userEntityOpt = userRepository.findById(userId);
		UserEntity userEntity = userEntityOpt.get();

		Optional<CategoryEntity> categoryEntityOpt = categoryRepository.findById(categoryId);
		CategoryEntity categoryEntity = categoryEntityOpt.get();

		PostEntity postEntity = PostEntity.convertDtoToEntity(postDto);

		postEntity.setCategoryEntity(categoryEntity);
		postEntity.setUserEntity(userEntity);

		PostEntity postEntityRes = postRepository.save(postEntity);
		System.out.println("data saved________________");
		PostDto postDtoRes = PostDto.convertEntityToDto(postEntityRes);
		return postDtoRes;
	}

	@Override
	public PostDto getPostById(Long id) {
		PostEntity postEntity = postRepository.findPostById(id);
		PostDto postDto = PostDto.convertEntityToDto(postEntity);

		return postDto;
	}

	@Override
	public String deletePost(Long id) {
		PostEntity postEntity = postRepository.findPostById(id);
		postRepository.delete(postEntity);
		return "Post Deleted Successfully";
	}

	@Override
	public List<ResponseDemo> findAllPost() {
		List<PostEntity> postEntity = postRepository.findAll();
		List<ResponseDemo> RpostDto = postEntity.stream().map(ResponseDemo::convertEntityToDto)
				.collect(Collectors.toList());

		for (ResponseDemo i : RpostDto) {
			i.setForm(postRepository.findTitleByid(i.getId()));

			DemoList demoList = new DemoList();

			demoList.setId(i.getId());
			demoList.setForm(postRepository.findTitleByid(i.getId()));

			i.setDemoList(demoList);

		}

		return RpostDto;
	}

}
