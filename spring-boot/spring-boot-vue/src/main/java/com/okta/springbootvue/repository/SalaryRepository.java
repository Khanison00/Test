package com.okta.springbootvue.repository;
import com.okta.springbootvue.entity.Salary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface SalaryRepository extends JpaRepository<Salary, Long>{
    Salary findById(long id);
}
