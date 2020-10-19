package com.dull.piqued.dto;

import com.dull.piqued.models.Department;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeResponseDTO {
    private long ecNumber;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String physicalAddress;
    private double salary;
    private Date hireDate;
    private JobResponseDTO job;
    private Department department;
    private Date createdAt;
    private Date updatedAt;
}
