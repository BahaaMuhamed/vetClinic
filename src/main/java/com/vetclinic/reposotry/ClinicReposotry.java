package com.vetclinic.reposotry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vetclinic.entity.Clinic;

import java.lang.String;
import java.util.List;

@Repository
public interface ClinicReposotry extends JpaRepository<Clinic, Long> {
	List<Clinic> findByClinikAdderssOrClinicPhoneContaining(String Address,String phoneNumber);
	
	@Query("select c from Clinic c where c.clinicId=:ID")
	public Clinic getClinicByID(@Param("ID")Long ID);
	

}
