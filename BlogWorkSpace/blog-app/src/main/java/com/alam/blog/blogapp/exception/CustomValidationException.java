package com.alam.blog.blogapp.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomValidationException extends RuntimeException{

	private String message;
	
	public CustomValidationException(String message) {
		super();
		this.message = message;
	}
	
	

}
