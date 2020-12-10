package com.vetclinic.reposotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetclinic.entity.Visit;

public interface VisitReposotry extends JpaRepository<Visit, Long> {

}
