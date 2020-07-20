package com.example.demo.dto;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Project;

@Component
public class ProjectDTO {
	private String ProjectID;
	private String description;
	private String unit;
	private String skillsRequired;
	private String managerId;
	private int noOfDemand;
	private String appliedList;
	private String selectedList;
	
	public String getSelectedList() {
		return selectedList;
	}
	public void setSelectedList(String selectedList) {
		this.selectedList = selectedList;
	}
	public String getProjectID() {
		return ProjectID;
	}
	public void setProjectID(String projectID) {
		ProjectID = projectID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getSkillsRequired() {
		return skillsRequired;
	}
	public void setSkillsRequired(String skillsRequired) {
		this.skillsRequired = skillsRequired;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public int getNoOfDemand() {
		return noOfDemand;
	}
	public void setNoOfDemand(int noOfDemand) {
		this.noOfDemand = noOfDemand;
	}
	public String getAppliedList() {
		return appliedList;
	}
	public void setAppliedList(String appliedList) {
		this.appliedList = appliedList;
	}
	
	public Project toProjectEntity(ProjectDTO projectDTO) {
		Project project=new Project();
		project.setProjectID(projectDTO.getProjectID());
		project.setUnit(projectDTO.getUnit());
		project.setSkillsRequired(projectDTO.getSkillsRequired());
		project.setAppliedList(projectDTO.getAppliedList());
		project.setDescription(projectDTO.getDescription());
		project.setManagerId(projectDTO.getManagerId());
		project.setNoOfDemand(projectDTO.getNoOfDemand());
		project.setSelectedList(projectDTO.getSelectedList());
		return project;
	}
	
	
	public ProjectDTO toProjectDTO(Project prj) {
		ProjectDTO projectDTO=new ProjectDTO();
		projectDTO.setProjectID(prj.getProjectID());
		projectDTO.setUnit(prj.getUnit());
		projectDTO.setSkillsRequired(prj.getSkillsRequired());
		projectDTO.setAppliedList(prj.getAppliedList());
		projectDTO.setDescription(prj.getDescription());
		projectDTO.setManagerId(prj.getManagerId());
		projectDTO.setNoOfDemand(prj.getNoOfDemand());
		projectDTO.setSelectedList(prj.getSelectedList());
		return projectDTO;
	}
}
