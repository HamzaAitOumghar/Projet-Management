package com.projet.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.dao.ProjectRepository;
import com.projet.entity.Project;
import com.projet.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	ResponseEntity<?> addNewProject(@Valid @RequestBody Project p,BindingResult result) throws Exception
	{
		Map<String, String> errorsMessages = new HashMap<String, String>();
 
		for(FieldError error : result.getFieldErrors()) {
			errorsMessages.put(error.getField(), error.getDefaultMessage());
		}
		
		if(result.hasErrors()) {
			return new ResponseEntity<Map<String, String>>(errorsMessages,HttpStatus.BAD_REQUEST);
		}
		
		Project newProject = this.projectService.saveOrUpdateProject(p);
		return new ResponseEntity<Project>(newProject,HttpStatus.CREATED);
	}
}
