package com.dull.piqued.dto;

import com.dull.piqued.models.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class JobResponseDTO {
    private long id;
    private String title;
    private double minSalary;
    private double maxSalary;
    private Date createdAt;
    private Date updatedAt;
}
