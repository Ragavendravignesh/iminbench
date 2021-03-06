package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProjectDTO;
import com.example.demo.entity.Project;
import com.example.demo.exception.ProjectException;
import com.example.demo.repository.ProjectRepo;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired 
	ProjectRepo projectRepo;
	
	@Autowired
	ProjectDTO ProjectDTO;
	
	public List<ProjectDTO> getProjects() throws ProjectException {
		try {
			List<Project> list= projectRepo.findAll();
			List<ProjectDTO> dtoList=new ArrayList<>();
			for(Project prj:list) {
				dtoList.add(ProjectDTO.toProjectDTO(prj));
			}
			return dtoList;
		}catch(Exception ex) {
			throw new ProjectException("No data");
		}
	}


	public ProjectDTO getProject(String prjid) throws ProjectException {
		try {
			Optional<Project> prj=projectRepo.findById(prjid);
			//ProjectDTO prjDTO=ProjectDTO.toProjectDTO(prj);
			ProjectDTO prjDTO=new ProjectDTO();
			prjDTO.setProjectID(prj.get().getProjectID());
			prjDTO.setUnit(prj.get().getUnit());
			prjDTO.setSkillsRequired(prj.get().getSkillsRequired());
			prjDTO.setAppliedList(prj.get().getAppliedList());
			prjDTO.setDescription(prj.get().getDescription());
			prjDTO.setManagerId(prj.get().getManagerId());
			prjDTO.setNoOfDemand(prj.get().getNoOfDemand());
			prjDTO.setSelectedList(prj.get().getSelectedList());
			return prjDTO;
		}catch(Exception ex) {
			throw new ProjectException("Project Not found");
		}
	}

	public String storeProject(ProjectDTO projectDTO) throws ProjectException {
		try {
			if(projectRepo.existsById(projectDTO.getProjectID())) {
				throw new ProjectException("Project Already exits with same id");
			}
			else {
				projectRepo.saveAndFlush(ProjectDTO.toProjectEntity(projectDTO));
				return "Added Successfully";
			}
		}catch(Exception ex) {
			throw new ProjectException("Sorry Not able to add project");
		}
	}

	public List<ProjectDTO> getProjectForManagerID(String managerId) throws ProjectException {
		try{
			List<Project> list=projectRepo.findByManagerId(managerId);
			List<ProjectDTO> dtoList=new ArrayList<>();
			for(Project project: list) {
				dtoList.add(ProjectDTO.toProjectDTO(project));
			}
			return dtoList;
		}catch (Exception e) {
			throw new ProjectException("Unable to retrieve data");
		}
	}


	public String UpdateApplied(String emailId, ProjectDTO projectDTO) throws ProjectException {
		Project prjDto=projectRepo.getOne(projectDTO.getProjectID());
		String appliedList=prjDto.getAppliedList();
		String updatedList=appliedList+","+emailId;
		prjDto.setAppliedList(updatedList);
		try {
			projectRepo.save(prjDto);
			return "Updated sucessfully";
		}catch(Exception e) {
			throw new ProjectException("Not Able to Update");
		}
	}
	
	public String selectFresher(ProjectDTO projectDTO, String fresheremail)
			throws ProjectException {
		Project prj=projectRepo.getOne(projectDTO.getProjectID());
		if(prj.getSelectedList().equals("null")) {
			prj.setSelectedList(fresheremail);
		}
		else {
			String email=prj.getSelectedList()+","+fresheremail;
			prj.setSelectedList(email);
		}
		String appliedList=prj.getAppliedList();
		String names[]=appliedList.split(",");
		String newList="";
		for(String name:names) {
			if(name.equals(fresheremail))
				continue;
			newList+=name+",";
		}
		prj.setAppliedList(newList);
		int Noofdemand=prj.getNoOfDemand();
		prj.setNoOfDemand((Noofdemand-1));
		try {
			projectRepo.save(prj);
			return "selected";
		}catch(Exception e) {
			throw new ProjectException("Not able to select");
		}
	}
	
}
