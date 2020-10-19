package com.dull.piqued.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "misconducts")
public class Misconduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private Date dateOccurred;

    @Column
    private String punishment;

    @Column
    private String punishmentDate;

    @ManyToMany(mappedBy = "misconducts")
    private List<Employee> employees;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}
