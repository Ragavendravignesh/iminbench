package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FresherDTO;
import com.example.demo.exception.FresherException;
import com.example.demo.service.FresherService;

@CrossOrigin(origins = "*", allowedHeaders = "*" )
@RestController
public class FresherController {
	
	@Autowired
	FresherService fresherService;
	
	@GetMapping("/isRegistered/{emailid}")
	public boolean isRegistered(@PathVariable String emailid) throws FresherException{
		return fresherService.isRegistered(emailid);
	}
	
	@PostMapping("/register")
	public String register(@RequestBody FresherDTO fresherDTO) throws FresherException{
		String response=fresherService.register(fresherDTO);
		return response;
	}
	
	@GetMapping("/getFresher/{emailid}")
	public ResponseEntity<FresherDTO> getFresher(@PathVariable String emailid) throws FresherException{
		FresherDTO fresherDTO=fresherService.getFresher(emailid);
		return new ResponseEntity<FresherDTO>(fresherDTO,HttpStatus.OK);
	}
	
	@GetMapping("/getFreshers")
	public List<FresherDTO> getFreshers() throws FresherException{
		List< FresherDTO> list=fresherService.getFreshers();
		return list;
	}
}
