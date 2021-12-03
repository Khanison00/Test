package com.okta.springbootvue.repository;
import com.okta.springbootvue.entity.Calc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CalcRepository extends JpaRepository<Calc, Long> {
	Calc findById(long id);}
