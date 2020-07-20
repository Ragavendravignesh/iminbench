package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FresherRepo;
import com.example.demo.dto.FresherDTO;
import com.example.demo.entity.Fresher;
import com.example.demo.exception.FresherException;

@Service
public class FresherServiceImpl implements FresherService {
	
	@Autowired
	FresherRepo fresherRepo;
	
	@Autowired 
	FresherDTO FresherDTO;
	
	public boolean isRegistered(String emailid) throws FresherException {
		try {
			boolean isRegister=fresherRepo.existsById(emailid);
			return isRegister;
		}catch (Exception e) {
			throw new FresherException(e.getMessage());			
		}	
	}
	public String register(FresherDTO fresherDTO) throws FresherException {
		Fresher fresher=FresherDTO.toFresherEntity(fresherDTO);
		try {
			if(fresherRepo.existsById(fresher.getEmailid()))
				return "Sorry Already Registered";
			else {
				fresherRepo.saveAndFlush(fresher);
				return "Registered Successfully";
			}
			
		}catch (Exception e) {
			throw new FresherException("Something went wrong");
		}
	}
	/*public List<FresherDTO> getRegisteredPeople(String[] appliedIds) throws FresherException {
		try {
			List<Fresher> fresherList=fresherRepo.findAll();
			List<FresherDTO> registeredList=new ArrayList<>();
			for(Fresher fresher:fresherList) {
				for(String appliedId: appliedIds) {
					if(fresher.getEmailid().equals(appliedId)) {
						registeredList.add(FresherDTO.toFresherDTO(fresher));
					}
				}
			}
			
			return registeredList;
		}catch (Exception e) {
			throw new FresherException("Unable to get Data");
		}
	}*/
	@Override
	public FresherDTO getFresher(String emailid) throws FresherException {
		try {
			Optional<Fresher> fresher=fresherRepo.findById(emailid);
			FresherDTO fresherDTO=new FresherDTO();
			fresherDTO.setDescription(fresher.get().getDescription());
			fresherDTO.setEmaild(fresher.get().getEmailid());
			fresherDTO.setGithuburl(fresher.get().getGithuburl());
			fresherDTO.setName(fresher.get().getName());
			fresherDTO.setTechnology(fresher.get().getTechnology());
			fresherDTO.setUnit(fresher.get().getUnit());
			
			return fresherDTO;
		}
		catch (Exception e) {
			throw new FresherException("Something went wrong");
		}
	}
	public List<FresherDTO> getFreshers() throws FresherException {
		try {
			List<Fresher> list= fresherRepo.findAll();
			List<FresherDTO> dtoList=new ArrayList<>();
			for(Fresher frs:list) {
				dtoList.add(FresherDTO.toFresherDTO(frs));
			}
			return dtoList;
		}catch (Exception e) {
			throw new FresherException("Something went wrong");
		}
	}
	
}
