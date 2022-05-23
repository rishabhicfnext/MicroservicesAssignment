package com.project.controller;

import com.project.dao.impl.ProjectRepositoryImpl;
import com.project.exception.ProjectAlreadyExistException;
import com.project.exception.ProjectNotFoundException;
import com.project.model.Project;
import com.project.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectController {

    @Autowired
    ProjectRepositoryImpl projectRepository;

    @PostMapping("/createproject")
    public Project addProject(@Valid @RequestBody Project project) {
        log.info("Inside add project controller method");
        boolean isExistByProjectName = projectRepository.isProjectExistByProjectName(project.getProjectName());
        if (isExistByProjectName) {
            throw new ProjectAlreadyExistException();
        }
        return projectRepository.createProject(project);
    }

    @PutMapping("/updateproject/{id}")
    public Project updateProject(@PathVariable("id") long id, @Valid @RequestBody Project project) {
        log.info("Inside upadte project controller method");
        boolean isExistByProjectID = projectRepository.isProjectExistByProjectID(id);
        if (isExistByProjectID) {
            return projectRepository.updateProject(project);
        }
        throw new ProjectNotFoundException();
    }

    @GetMapping("/getbyprojectid/{id}")
    public Project getProject(@PathVariable("id") long id) {
        log.info("Inside Get project By ID controller method");
        boolean isExistByProjectID = projectRepository.isProjectExistByProjectID(id);
        if (isExistByProjectID) {
            return projectRepository.fetchProjectById(id);
        }
        throw new ProjectNotFoundException();
    }

    @GetMapping("/allprojects")
    public List<Project> getProjects() {
        log.info("Inside Get All Project controller method");
        return projectRepository.fetchAllProjects();
    }

    @DeleteMapping("/deletebyprojectid/{id}")
    public String deleteProject(@PathVariable("id") long id) {
        log.info("Inside Delete By ID Project controller method");
        boolean isExistByProjectID = projectRepository.isProjectExistByProjectID(id);
        if (isExistByProjectID) {
            return projectRepository.deleteProjectById(id);
        }
        throw new ProjectNotFoundException();
    }

    @GetMapping("/getallusersbyprojectid/{projectID}")
    public ResponseTemplateVO getAllUserByProjectID(@PathVariable("projectID") long projectID) {
        log.info("Inside Get All User By Project ID controller method");
        boolean isExistByProjectID = projectRepository.isProjectExistByProjectID(projectID);
        if (isExistByProjectID) {
            return projectRepository.getAllUserWithProject(projectID);
        }
        throw new ProjectNotFoundException();
    }
}