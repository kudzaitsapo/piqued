package com.dull.piqued.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DepartmentResponseDTO {
    private long departmentId;
    private String name;
    private Date createdAt;
    private Date updatedAt;
}
