package com.okta.springbootvue.controller;

import com.okta.springbootvue.entity.EmployeeType;
import com.okta.springbootvue.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/emptype")
public class EmployeeTypeController {

    @Autowired
    private final EmployeeTypeRepository emptypeRepository;

    public EmployeeTypeController(EmployeeTypeRepository emptypeRepository) {
        this.emptypeRepository = emptypeRepository;
    }

    @GetMapping("")
    public Collection<EmployeeType> getAllBaggageType() {
        return emptypeRepository.findAll();
    }

}