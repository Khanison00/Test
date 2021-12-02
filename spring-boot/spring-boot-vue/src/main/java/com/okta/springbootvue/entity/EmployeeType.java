package com.okta.springbootvue.entity;
import lombok.*;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



@Data
@Entity
@NoArgsConstructor
public class EmployeeType {
    @Id
    @SequenceGenerator(name="EMPLOYEETYPE_SEQ",sequenceName="EMPLOYEETYPE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="EMPLOYEETYPE_SEQ")
    @Column(name="EMPLOYEETYPE_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String emptypename;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmptypename() {
        return emptypename;
    }

    public void setEmptypename(String emptypename) {
        this.emptypename = emptypename;
    }
    
}
