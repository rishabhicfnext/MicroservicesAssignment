package com.project.dao.impl;

import com.project.dao.ProjectRepository;
import com.project.dao.ProjectRowMapper;
import com.project.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private static final String INSERT_PROJECT_QUERY = "INSERT INTO PROJECT(projectid,projectstartdate,projectenddate,budgetallotted,budgetused,typeofproject,projectname,userid) values(?,?,?,?,?,?,?,?)";
    private static final String UPDATE_PROJECT_BY_ID_QUERY = "UPDATE PROJECT SET budgetused=? WHERE projectid=?";
    private static final String GET_PROJECT_BY_ID_QUERY = "SELECT * FROM PROJECT WHERE projectid=?";
    private static final String DELETE_PROJECT_BY_ID_QUERY = "DELETE FROM PROJECT WHERE projectid=?";
    private static final String GET_PROJECTS_QUERY = "SELECT * FROM PROJECT";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public Project createProject(Project project) {
        getJdbcTemplate().update(INSERT_PROJECT_QUERY, project.getProjectID(), project.getProjectStartDate(), project.getProjectEndDate(), project.getBudgetAllotted(), project.getBudgetUsed(), project.getTypeOfProject(), project.getProjectName(), project.getUserID());
        return project;
    }

    @Override
    public Project updateProject(Project project) {
        getJdbcTemplate().update(UPDATE_PROJECT_BY_ID_QUERY, project.getBudgetUsed(), project.getProjectID());
        return project;
    }

    @Override
    public Project fetchProjectById(Long projectId) {
        return getJdbcTemplate().queryForObject(GET_PROJECT_BY_ID_QUERY, new ProjectRowMapper(), projectId);
    }

    @Override
    public List<Project> fetchAllProjects() {
        return getJdbcTemplate().query(GET_PROJECTS_QUERY, new ProjectRowMapper());
    }

    @Override
    public String deleteProjectById(Long projectId) {
//        String SQL = "DELETE FROM project WHERE project_id = ?";
//        int update = getJdbcTemplate().update(SQL, projectId);
//        if (update == 1) {
//            System.out.println("Project is deleted with ID = " + projectId);
//        }
//        return null;
        getJdbcTemplate().update(DELETE_PROJECT_BY_ID_QUERY, projectId);
        return "Project got deleted with projectid  : " + projectId;
    }
}
