package com.sandesh.initial.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long departmentId;

    @NotBlank(message="Department Name can't be empty")
    @Length(max = 10, min = 3, message = "Department name should be at least 3 and at most 5 characters")
    @Column(unique = true)
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
