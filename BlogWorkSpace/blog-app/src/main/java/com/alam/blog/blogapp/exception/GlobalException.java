package com.alam.blog.blogapp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.alam.blog.blogapp.response.AppResponse;

@RestController
@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value = CustomValidationException.class)
    public ResponseEntity<AppResponse> ExceptionHandle(CustomValidationException ex){
    	
		String message=ex.getMessage();
    	AppResponse error=new AppResponse(404,message,new Date());

    	return new ResponseEntity<AppResponse>(error,HttpStatus.NOT_FOUND);
    }

}
