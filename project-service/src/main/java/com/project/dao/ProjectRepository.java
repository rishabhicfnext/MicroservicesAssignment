package com.project.dao;

import com.project.model.Project;

import java.util.List;

public interface ProjectRepository {

    Project createProject(Project project);

    Project updateProject(Project project);

    Project fetchProjectById(Long projectId);

    List<Project> fetchAllProjects();

    String deleteProjectById(Long projectId);
}