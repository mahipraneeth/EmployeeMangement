package com.pratishthan.EV.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Emp_details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Employee_Name",nullable = false)
    private String name;
    @Column(name = "Employee_Email",nullable = false)
    private String eMail;
    @Column(name = "organisation",nullable = false)
    private String organisation;
}
