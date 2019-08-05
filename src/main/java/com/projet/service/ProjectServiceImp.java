package com.projet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.projet.dao.ProjectRepository;
import com.projet.entity.Project;

@Service
public class ProjectServiceImp implements ProjectService {

	
	@Autowired
	private ProjectRepository repo;

	@Override
	public Project saveOrUpdateProject(Project p) {
		return this.repo.save(p);
	}
	

}
