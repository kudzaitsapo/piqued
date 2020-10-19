package com.dull.piqued.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MisconductResponseDTO {
    private long id;
    private String name;
    private String description;
    private Date dateOccurred;
    private String punishment;
    private String punishmentDate;
    private Date createdAt;
    private Date updatedAt;
}
