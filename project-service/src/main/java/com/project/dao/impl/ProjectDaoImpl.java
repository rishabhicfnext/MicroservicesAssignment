package com.project.dao.impl;

import com.project.dao.ProjectDao;
import com.project.dao.ProjectRowMapper;
import com.project.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public void createProject(Project project) {
        String SQL = "INSERT INTO project(project_id, project_start_date, project_end_date, budget_allotted, budget_used, type_of_project) VALUES (?,?,?,?,?,?)";
        int update = getJdbcTemplate().update(SQL, project.getProjectID(), project.getProjectStartDate(), project.getProjectEndDate(), project.getBudgetAllotted(), project.getBudgetUsed(), project.getTypeOfProject());
        if (update == 1) {
            System.out.println("Project is created..");
        }
    }

    @Override
    public Project fetchProjectById(Long projectId) {
        String SQL = "SELECT * FROM project WHERE project_id = ?";
        return getJdbcTemplate().queryForObject(SQL, new ProjectRowMapper(), projectId);
    }

    @Override
    public List<Project> fetchAllProjects() {
        String SQL = "SELECT * FROM project";
        return getJdbcTemplate().query(SQL, new ProjectRowMapper());
    }

    @Override
    public void deleteProjectById(Long projectId) {
        String SQL = "DELETE FROM project WHERE project_id = ?";
        int update = getJdbcTemplate().update(SQL, projectId);
        if (update == 1) {
            System.out.println("Project is deleted with ID = " + projectId);
        }
    }
}
