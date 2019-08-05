package com.projet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.entity.Project;

public interface ProjectRepository extends JpaRepository<Project,Long> {

}
