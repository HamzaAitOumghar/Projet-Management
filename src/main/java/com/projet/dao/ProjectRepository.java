package com.projet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Long> {
	
	Project findByProjectIdentifier(String projectIdentifier);

	
}
