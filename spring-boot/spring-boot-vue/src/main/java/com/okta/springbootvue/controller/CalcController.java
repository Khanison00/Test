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
import com.okta.springbootvue.repository.CalcRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/calc")
public class CalcController {

    @Autowired
    private CalcRepository calcRepository;
    @Autowired
    private EmployeeRepository empRepository;

    public CalcController(EmployeeRepository empRepository, CalcRepository calRepository) {
        this.calcRepository = calRepository;
        this.empRepository = empRepository;
    }

    @GetMapping("")
    public Collection<Calc> getEmp() {
        return calcRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @PostMapping("/{emp}/{hour}")
    public Calc newClac(Calc newCalc,
    
    @PathVariable long emp,
    @PathVariable Double hour
    )
    {
                
    Employee addeCalc = empRepository.findById(emp);

    newCalc.setResult(hour);
    newCalc.setEmp(addeCalc);

    return calcRepository.save(newCalc);
    }

}
