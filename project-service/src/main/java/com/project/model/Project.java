package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Project implements Serializable {

    private Long projectID;

    @Temporal(value = TemporalType.DATE)
    @NotNull(message = "Project Start Date can't be null")
    private Date projectStartDate;

    @Temporal(value = TemporalType.DATE)
    @NotNull(message = "Project End Date can't be null")
    private Date projectEndDate;

    private int budgetAllotted;

    private int budgetUsed;

    @NotEmpty(message = "Type of Project can't be empty")
    @NotNull(message = "Type of Project can't be null")
    private String typeOfProject;

    @NotEmpty(message = "Project name can't be empty")
    @NotNull(message = "Project name can't be null")
    private String projectName;

    private long userID;

//    @Enumerated(EnumType.STRING)s
//    private TypeOfProject typeOfProject;
//
//    public Project(long projectID, java.sql.Date projectStartDate, java.sql.Date projectEndDate, int budgetAllotted, int budgetUsed, String string) {
//    }
}

