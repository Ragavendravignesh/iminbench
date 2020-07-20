package com.example.demo.utilities;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.LoginException;
import com.example.demo.exception.SignUpException;

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> generalExceptionHandler(Exception ex){
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMsg(ex.getMessage());
		
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorInfo> loginExceptionHandler(Exception ex){
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMsg(ex.getMessage());
		
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SignUpException.class)
	public ResponseEntity<ErrorInfo> signUpExceptionHandler(Exception ex){
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMsg(ex.getMessage());
		
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.OK);
	}
}
