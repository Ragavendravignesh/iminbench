package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.FresherDTO;
import com.example.demo.dto.ProjectDTO;
import com.example.demo.exception.ProjectException;
import com.example.demo.service.ProjectService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	FresherFeign fresherFeign;
	
	@GetMapping("/getProjects/{emailId}")
	public ResponseEntity<List<ProjectDTO>> getProjects(@PathVariable String emailId) throws ProjectException{
		List<ProjectDTO> list=projectService.getProjects();
		List<ProjectDTO> ulist = new ArrayList<>();
		for(ProjectDTO dto:list) {
			String appliedList[]=dto.getAppliedList().split(",");
			boolean flag=false;
			for(String name:appliedList) {
				if(emailId.equals(name)) {
					flag=true;
				}
			}
			if(flag==false)
				ulist.add(dto);
		}
		return new ResponseEntity<List<ProjectDTO>>(ulist,HttpStatus.OK);
	}
	
	@GetMapping("/getProject/{prjid}")
	public ResponseEntity<ProjectDTO> getProject(@PathVariable String prjid) throws ProjectException{
		ProjectDTO projectDTO=projectService.getProject(prjid);
		return new ResponseEntity<ProjectDTO>(projectDTO,HttpStatus.OK);
	}
	
	@PostMapping("/storeProject")
	public String storeProject(@RequestBody ProjectDTO projectDTO) throws ProjectException{
		String response=projectService.storeProject(projectDTO);
		return response;
	}
	
	@GetMapping("/getProjectForManagerId/{managerId}")
	public List<ProjectDTO> getProjectForManagerId(@PathVariable String managerId) throws ProjectException{
		List<ProjectDTO> dtos=projectService.getProjectForManagerID(managerId);
		return dtos;
	}
	
	@PutMapping("/updateApplied/{emailId}")
	public String updateApplied(@PathVariable String emailId,@RequestBody ProjectDTO projectDTO) throws ProjectException {
		String res=projectService.UpdateApplied(emailId, projectDTO);
		return res;
	}
	
	@GetMapping("/getAppliedFreshers/{prjId}")
	public List<FresherDTO> getAppliedFreshers(@PathVariable String prjId) throws ProjectException{
		ProjectDTO projectDTO=projectService.getProject(prjId);
		List<FresherDTO> appliedFreshers=new ArrayList<FresherDTO>();
		ObjectMapper mapper=new ObjectMapper();
		List<FresherDTO> fresherList=mapper.convertValue(fresherFeign.getFreshers(),
				new TypeReference<List<FresherDTO>>() {
				});
		String applied=projectDTO.getAppliedList();
		String appliedList[]=applied.split(",");
		for(String email:appliedList) {
			System.out.println(email);
			for(FresherDTO frs:fresherList) {
				
				if(frs.getEmaild().equals(email))
					appliedFreshers.add(frs);
			}
		}
		return appliedFreshers;
	}
	
	@PutMapping("/selectFresher/{prjId}/{fresheremail}")
	public String selectFresher(@PathVariable String prjId,@PathVariable String fresheremail) throws ProjectException{
		ProjectDTO projectDTO=projectService.getProject(prjId);
		String resp=projectService.selectFresher(projectDTO,fresheremail);
		return resp;
	}
	
	@GetMapping("/getDemandCount/{prjId}")
	public int getDemandCount(@PathVariable String prjId) throws ProjectException{
		ProjectDTO projectDTO=projectService.getProject(prjId);
		return projectDTO.getNoOfDemand();
	}
}
