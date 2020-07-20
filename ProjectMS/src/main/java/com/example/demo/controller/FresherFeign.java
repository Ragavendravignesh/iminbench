package com.example.demo.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dto.FresherDTO;

@FeignClient("FresherMS")
public interface FresherFeign {
	
	@GetMapping(value="fresher/getFreshers")
	public List<FresherDTO> getFreshers();

}
