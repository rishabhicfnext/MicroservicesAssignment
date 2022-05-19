package com.project.dao;

import com.project.model.Project;

import java.util.List;

public interface ProjectDao {

    void createProject(Project project);

    Project fetchProjectById(Long projectId);

    List<Project> fetchAllProjects();

    void deleteProjectById(Long projectId);
}