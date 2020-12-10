package com.vetclinic.reposotry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vetclinic.entity.Doctor;

@Repository
public interface DoctorRepostry extends JpaRepository<Doctor, Long> {

	public List<Doctor> findByClincClinicId(Long clinicId);
}
