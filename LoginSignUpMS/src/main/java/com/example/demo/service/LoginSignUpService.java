package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.exception.LoginException;
import com.example.demo.exception.SignUpException;

@Service
public interface LoginSignUpService {
	
	public String Login(UserDTO userDTO ) throws LoginException;
	public String SignUp(UserDTO userDTO) throws SignUpException;
	public List<User> getDetails();

}
