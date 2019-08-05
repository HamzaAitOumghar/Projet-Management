package com.projet.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.entity.Project;
import com.projet.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService service;
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	Project addNewProject(@RequestBody Project p) {
		return this.service.saveOrUpdateProject(p);
	}
}
