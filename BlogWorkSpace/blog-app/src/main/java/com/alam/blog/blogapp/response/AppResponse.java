package com.alam.blog.blogapp.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppResponse {
	
	int status;
	String error;
	Date date;
	public AppResponse(int status, String error, Date date) {
		super();
		this.status = status;
		this.error = error;
		this.date = date;
	}
	
	

}
