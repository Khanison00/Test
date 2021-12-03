package com.okta.springbootvue.entity;
import lombok.*;


import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.print.DocFlavor.STRING;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
public class Salary {
    @Id
    @SequenceGenerator(name="SALARY_SEQ",sequenceName="SALARY_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SALARY_SEQ")
    @Column(name = "SALARY_SEQ", unique = true, nullable = true)
    private Long id;

    private @NonNull String firstname;
    private @NonNull String lastname;
    private @NonNull Double salary;

    // private Date empBrithday;
    

    // @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    // @JoinColumn(name = "EMPLOYEE_SEQ", insertable = true)
    // private  Employee firstname;

    // @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    // @JoinColumn(name = "EMPLOYEE_SEQ", insertable = true)
    // private  Employee lastname;

    // @ManyToOne(fetch = FetchType.EAGER, targetEntity = Employee.class)
    // @JoinColumn(name = "EMPLOYEE_SEQ", insertable = true)
    // private  Employee salary;

    public Double getSalaryDB() {
        return salary;
    }

    public void setSalaryDB(Double salary) {
        this.salary = salary;
    }
    
    public String getFirstnameSDB() {
        return firstname;
    }

    public void setFirstnameSDB(String firstname) {
        this.firstname = firstname;
    }

    public String getLasstnameSDB() {
        return lastname;
    }

    public void setLasstnameSDB(String lastname) {
        this.lastname = lastname;
    }

}
