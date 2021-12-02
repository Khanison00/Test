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

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private final EmployeeRepository empRepository;
    @Autowired
    private EmployeeTypeRepository empTypeRepository;


    public EmployeeController(EmployeeRepository empRepository, EmployeeTypeRepository empTypeRepository) {
    this.empRepository = empRepository;
    this.empTypeRepository = empTypeRepository; }

    @GetMapping("")
    public Collection<Employee> getEmpType() {
        return empRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @PostMapping("/{firstname}/{lastname}/{emptype_id}/{salary}/{compentsation}")
    public Employee newEmployee(Employee newEmployee,
    
    @PathVariable String firstname,
    @PathVariable String lastname,
    @PathVariable long emptype_id,
    @PathVariable Double salary,
    @PathVariable Double compentsation
    )
    {
                
    EmployeeType addeEmployeeType = empTypeRepository.findById(emptype_id);

    newEmployee.setFirstname(firstname);
    newEmployee.setLastname(lastname);
    newEmployee.setSalary(salary);
    newEmployee.setCompentsation(compentsation);
    newEmployee.setEmpType(addeEmployeeType);


    return empRepository.save(newEmployee);
    }
    

   
   


}
