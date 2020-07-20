package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

@Component
public class UserDTO {
	
	private String emailid;
	private String password;
	private String role;
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public User toUserEntity(UserDTO userDTO) {
		User user=new User();
		user.setEmailid(userDTO.getEmailid());
		user.setPassword(userDTO.getPassword());
		user.setRole(userDTO.getRole());
		
		return user;
	} 
	
	public UserDTO toUserDTO(User user) {
		UserDTO userDTO=new UserDTO();
		userDTO.setEmailid(user.getEmailid());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole(user.getRole());
		return userDTO;
	}
	
}
