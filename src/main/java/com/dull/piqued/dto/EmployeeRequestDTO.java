package com.dull.piqued.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeRequestDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String physicalAddress;
    private double salary;
    private Date hireDate;
}
