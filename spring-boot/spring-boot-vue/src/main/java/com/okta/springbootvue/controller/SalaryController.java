package com.okta.springbootvue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;
import java.util.Date;
import com.okta.springbootvue.entity.*;
import com.okta.springbootvue.repository.EmployeeRepository;
import com.okta.springbootvue.repository.EmployeeTypeRepository;
import com.okta.springbootvue.repository.SalaryRepository;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/empl")
public class SalaryController {


    @Autowired
    private SalaryRepository empSalary;
    @Autowired
    private EmployeeRepository empRepository;
    @Autowired
    private EmployeeTypeRepository empTypeRepository;


    public SalaryController(SalaryRepository empSalary, EmployeeRepository empRepository, EmployeeTypeRepository empTypeRepository) {
    this.empSalary = empSalary;
    this.empRepository = empRepository;
    this.empTypeRepository = empTypeRepository; }

    @GetMapping("/salary")
    public Collection<Salary> getEmpType() {
        return empSalary.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    
    @PostMapping("/{firstname}/{lastname}/{emptype_id}/{salary}/{compentsation}")
    public Salary newEmployee(Salary newSalary,
    
    @PathVariable String firstname,
    @PathVariable String lastname,
    @PathVariable long emptype_id,
    @PathVariable Double salary,
    @PathVariable Double compentsation
    )
    {
                
        //Employee addSalary = empRepository.findById(emptype_id);
    
        newSalary.setFirstnameSDB(firstname);
        newSalary.setLasstnameSDB(lastname);
        //newSalary.setSalaryDB(addSalary);
    
    
        return empSalary.save(newSalary);
        }
}
