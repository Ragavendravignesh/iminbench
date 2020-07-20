package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepo;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.exception.LoginException;
import com.example.demo.exception.SignUpException;
import com.example.demo.service.LoginSignUpService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginSignUpController {
	
	@Autowired 
	private LoginSignUpService loginSignUpService;
	
	@PutMapping("/login")
	public String Login(@RequestBody UserDTO userDTO) throws LoginException {
		System.out.println("hi");
		System.out.println(userDTO.getEmailid()+userDTO.getPassword()+userDTO.getRole());
		String response=loginSignUpService.Login(userDTO);
		return response;
	}
	
	@PutMapping("/signup")
	public String SignUp(@RequestBody UserDTO userDTO)throws SignUpException{
		String response=loginSignUpService.SignUp(userDTO);
		return response;
	}
	
	@GetMapping("/getdetails")
	public List<User> getDetails(){
		System.out.println("hi");
		return loginSignUpService.getDetails();
	}
}
