package com.okta.springbootvue.entity;

import lombok.*;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor

public class Employee {
    @Id
    @SequenceGenerator(name="EMPLOYEE_SEQ",sequenceName="EMPLOYEE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EMPLOYEE_SEQ")
    @Column(name = "EMPLOYEE_SEQ", unique = true, nullable = true)
    private Long id;
   
    private @NonNull String firstname;
    private @NonNull String lastname;
    private @NonNull double salary;
    private @NonNull double compentsation;
    // private Date empBrithday;
    

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = EmployeeType.class)
    @JoinColumn(name = "EMPLOYEETYPE_ID", insertable = true)
    private  EmployeeType empType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getCompentsation() {
        return compentsation;
    }

    public void setCompentsation(Double compentsation) {
        this.compentsation = compentsation;
    }

    // public Date getEBday() {
    //     return empBrithday;
    // }

    // public void setEBDate(Date empBrithday) {
    //     this.empBrithday = empBrithday;
    // }

    public EmployeeType getEmpType() {
        return empType;
    }

    public void setEmpType(EmployeeType empTypeSelect) {
        this.empType = empTypeSelect;
    }

}
