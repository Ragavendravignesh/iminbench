package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepo;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.exception.LoginException;
import com.example.demo.exception.SignUpException;

import java.util.*;

@Service
public class LoginSignUpServiceImpl implements LoginSignUpService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserDTO UserDTO;
	
	public String Login(UserDTO userDTO) throws LoginException {
		User user=UserDTO.toUserEntity(userDTO);
		try {
			Optional<User> userResult=userRepo.findById(user.getEmailid());
			if(userResult.get().getEmailid().equals(user.getEmailid()) && 
					userResult.get().getPassword().equals(user.getPassword()) &&
					userResult.get().getRole().equals(user.getRole()))
				return "Logged in Sucessfully!";
			else
				return "Credentials Mismatch";
		}catch(Exception ex) {
			throw new LoginException("User not found, Sign Up!");
		}
	}

	public String SignUp(UserDTO userDTO) throws SignUpException {
		User user=UserDTO.toUserEntity(userDTO);
		try {
			
			if(userRepo.existsById(userDTO.getEmailid())) {
				return "User Already Exists";
				
			}
			else {
				userRepo.saveAndFlush(user);
				return "Signed Up successfully";
			}
			
		}catch(Exception ex) {
			throw new SignUpException("Sorry not able to register, try again.");
		}
	}
	
	public List<User> getDetails() {
		return userRepo.findAll();
	}

}
