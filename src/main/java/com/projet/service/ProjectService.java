package com.projet.service;

import java.util.List;

import com.projet.entity.Project;

public interface ProjectService {
	
	Project saveOrUpdateProject(Project p);
	Project findByProjectIdentifier(String pId);
	List<Project> findAllProject();
	void deleteProjectByIdentifier(String pId);
}
