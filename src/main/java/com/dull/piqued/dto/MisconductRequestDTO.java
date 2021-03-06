package com.dull.piqued.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MisconductRequestDTO {
    private String name;
    private String description;
    private Date dateOccurred;
    private String punishment;
    private String punishmentDate;
    private List<Long> employeeIds;
}
