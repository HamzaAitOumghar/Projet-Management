package com.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.dao.ProjectRepository;
import com.projet.entity.Project;
import com.projet.exception.ProjectIdException;

@Service
public class ProjectServiceImp implements ProjectService {

	@Autowired
	private ProjectRepository repo;

	@Override
	public Project saveOrUpdateProject(Project p) {
		try {
			p.setProjectIdentifier(p.getProjectIdentifier().toUpperCase());
			return this.repo.save(p);
		} catch (Exception e) {
			throw new ProjectIdException("Project Id '" + p.getProjectIdentifier().toUpperCase() + "' Already exists");
		}
	}

	@Override
	public Project findByProjectIdentifier(String pId) {

		Project p = this.repo.findByProjectIdentifier(pId.toUpperCase());

		if (p == null) {
			throw new ProjectIdException("Project '" + pId + "' does not exists");
		}

		return this.repo.findByProjectIdentifier(pId.toUpperCase());
	}

	@Override
	public List<Project> findAllProject() {
		return this.repo.findAll();
	}

	@Override
	public void deleteProjectByIdentifier(String pId) {
		Project p = this.findByProjectIdentifier(pId);
		
		if(p==null) {
			throw new ProjectIdException("can not delete project with id '" + pId + "' project does not exists");
		}
		this.repo.delete(p);
	}

}
