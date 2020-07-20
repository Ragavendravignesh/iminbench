package com.example.demo.dto;

import org.springframework.stereotype.Component;

import com.example.demo.entity.Fresher;

@Component
public class FresherDTO {
	private String emaild;
	private String name;
	private String githuburl;
	private String technology;
	private String unit;
	private String description;
	
	public String getEmaild() {
		return emaild;
	}
	public void setEmaild(String emaild) {
		this.emaild = emaild;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGithuburl() {
		return githuburl;
	}
	public void setGithuburl(String githuburl) {
		this.githuburl = githuburl;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Fresher toFresherEntity(FresherDTO fresherDTO) {
		Fresher fresher=new Fresher();
		fresher.setEmailid(fresherDTO.getEmaild());
		fresher.setName(fresherDTO.getName());
		fresher.setTechnology(fresherDTO.getTechnology());
		fresher.setGithuburl(fresherDTO.getGithuburl());
		fresher.setDescription(fresherDTO.getDescription());
		fresher.setUnit(fresherDTO.getUnit());
		return fresher;
	}
	
	public FresherDTO toFresherDTO(Fresher fresher) {
		FresherDTO fresherDTO=new FresherDTO();
		fresherDTO.setEmaild(fresher.getEmailid());
		fresherDTO.setName(fresher.getName());
		fresherDTO.setTechnology(fresher.getTechnology());
		fresherDTO.setGithuburl(fresher.getGithuburl());
		fresherDTO.setDescription(fresher.getDescription());
		fresherDTO.setUnit(fresher.getUnit());
		return fresherDTO;
	}
	
}
