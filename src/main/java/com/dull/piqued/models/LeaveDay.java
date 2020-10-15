package com.dull.piqued.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "leave_days")
public class LeaveDay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column
    private Date dateApproved;

    @Column
    private String leaveType;

    @Column
    private String description;

    @Column
    private String leaveStatus;

    @ManyToOne
    @JoinColumn(name = "employees_ecnumber")
    private Employee employee;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
