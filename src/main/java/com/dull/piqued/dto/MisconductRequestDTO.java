package com.dull.piqued.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MisconductRequestDTO {
    private String name;
    private String description;
    private Date dateOccurred;
    private String punishmentDate;
}
