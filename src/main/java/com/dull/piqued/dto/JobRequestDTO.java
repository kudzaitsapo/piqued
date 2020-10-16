package com.dull.piqued.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobRequestDTO {
    private String title;
    private double maxSalary;
    private double minSalary;
}
