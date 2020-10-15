package com.dull.piqued.dto;

import com.dull.piqued.models.Department;
import com.dull.piqued.models.Job;
import com.dull.piqued.models.LeaveDay;
import com.dull.piqued.models.Misconduct;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EmployeeResponseDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String physicalAddress;
    private double salary;
    private Date hireDate;
    private Job job;
    private Department department;
    private List<Misconduct> misconducts;
    private List<LeaveDay> leaveDays;
    private Date createdAt;
    private Date updatedAt;
}
