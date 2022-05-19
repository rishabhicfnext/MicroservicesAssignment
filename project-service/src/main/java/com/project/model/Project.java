package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Project {

    private Long projectID;

    @Temporal(value = TemporalType.DATE)
    @NotNull(message = "Project Start Date can't be null")
    private Date projectStartDate;

    @Temporal(value = TemporalType.DATE)
    @NotNull(message = "Project End Date can't be null")
    private Date projectEndDate;

    private int budgetAllotted;

    private int budgetUsed;

    @Enumerated(EnumType.STRING)
    private TypeOfProject typeOfProject;

    public Project(long projectID, java.sql.Date projectStartDate, java.sql.Date projectEndDate, int budgetAllotted, int budgetUsed, String string) {
    }
}

