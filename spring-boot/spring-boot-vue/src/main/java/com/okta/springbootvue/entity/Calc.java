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

public class Calc {
    @Id
    @SequenceGenerator(name="CALC_SEQ",sequenceName="CALC_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CALC_SEQ")
    @Column(name = "CALC_SEQ", unique = true, nullable = true)
    private Long id;
   
    private @NonNull Double Result;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    @JoinColumn(name = "EMPLOYEE_ID", insertable = true)
    private  Employee emp;
    


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getResult() {
        return Result;
    }

    public void setResult(Double Result) {
        this.Result = Result;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee empSelect) {
        this.emp = empSelect;
    }
}
