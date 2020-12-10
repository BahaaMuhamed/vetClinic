package com.vetclinic.reposotry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetclinic.entity.Owner;

@Repository
public interface OwnerReposotry extends JpaRepository<Owner, Long> {
	

}
