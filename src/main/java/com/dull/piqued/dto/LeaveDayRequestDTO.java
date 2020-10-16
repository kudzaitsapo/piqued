package com.dull.piqued.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LeaveDayRequestDTO {
    private Date startDate;
    private Date endDate;
    private Date dateApproved;
    private String leaveType;
    private String description;
    private String leaveStatus;
}
