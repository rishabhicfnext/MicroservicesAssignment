package com.project.controller;

import com.project.dao.impl.ProjectRepositoryImpl;
import com.project.model.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectController {

    @Autowired
    ProjectRepositoryImpl projectRepository;

    @PostMapping("/createproject")
    public Project addProject(@RequestBody Project project) {
        return projectRepository.createProject(project);
    }

    @PutMapping("/updateproject")
    public Project updateProject(@RequestBody Project project) {

        return projectRepository.updateProject(project);

    }

    @GetMapping("/getbyprojectid/{id}")
    public Project getProject(@PathVariable("id") long id) {
        return projectRepository.fetchProjectById(id);
    }

    @GetMapping("/allprojects")
    public List<Project> getProjects() {
        return projectRepository.fetchAllProjects();
    }

    @DeleteMapping("/deletebyprojectid/{id}")
    public String deleteProject(@PathVariable("id") long id) {
        return projectRepository.deleteProjectById(id);
    }


}
