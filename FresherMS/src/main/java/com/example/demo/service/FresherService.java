package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.FresherDTO;

import com.example.demo.exception.FresherException;

@Service
public interface FresherService {
	public boolean isRegistered(String emailid) throws FresherException;
	public String register(FresherDTO fresherDTO) throws FresherException;
	//public List<FresherDTO> getRegisteredPeople(String[] appliedIds) throws FresherException;
	public FresherDTO getFresher(String emailid) throws FresherException;
	public List<FresherDTO> getFreshers() throws FresherException;
}
