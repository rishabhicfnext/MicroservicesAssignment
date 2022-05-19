package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Project {

    @Id
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

}

