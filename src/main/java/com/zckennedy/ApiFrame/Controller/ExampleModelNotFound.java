package com.zckennedy.ApiFrame.Controller;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExampleModelNotFound extends RuntimeException {

	public ExampleModelNotFound() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExampleModelNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
