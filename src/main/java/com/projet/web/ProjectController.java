package com.projet.web;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.entity.Project;
import com.projet.service.ProjectService;
import com.projet.service.ValidationService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ValidationService validationService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addNewProject(@Valid @RequestBody Project p, BindingResult result) throws Exception {
		
		ResponseEntity<?> validationResult = validationService.mapValidationService(result);
		
		if (validationResult == null) {
			Project newProject = this.projectService.saveOrUpdateProject(p);
			return new ResponseEntity<Project>(newProject, HttpStatus.CREATED);
		}
		return validationResult;

	}
	
	
	@GetMapping("/{projectId}")
	public ResponseEntity<?> findProjectByIdentifier(@PathVariable("projectId") String projectIdentifier){
		Project project = this.projectService.findByProjectIdentifier(projectIdentifier);
		return new ResponseEntity<Project>(project,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Project> findAll(){
		return this.projectService.findAllProject();
	}
	
	
	@DeleteMapping("/{projectId}")
	public ResponseEntity<?> deleteProject(@PathVariable("projectId") String pId){
		this.projectService.deleteProjectByIdentifier(pId);
		return new ResponseEntity<String>("Project with id  '"+pId +"' Was deleted",HttpStatus.OK);
	}
	
	
}
