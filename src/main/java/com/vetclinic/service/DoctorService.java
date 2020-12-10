package com.vetclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetclinic.entity.Clinic;
import com.vetclinic.entity.Doctor;
import com.vetclinic.reposotry.DoctorRepostry;

@Service
public class DoctorService {
	@Autowired
	DoctorRepostry doctorRepostry;

	public void createDoctors(Doctor doctor) {
		if (doctor != null) {
			doctorRepostry.save(doctor);
		}
	}

	public Optional<Doctor> getDoctorById(Long doctorId) {
		Optional<Doctor> doctor = null;
		if (doctorId != null) {
			doctor = doctorRepostry.findById(doctorId);
		}
		return doctor;
	}
	
	
	public void assignDoctorToClinc(Doctor doctor){
		if(doctor!=null){
		doctorRepostry.save(doctor);
		}
	}
	
	public void reAssignDoctorToClinc(Doctor doctor){
		if(doctor!=null && doctor.getDoctorId()!=null){
		doctorRepostry.save(doctor);
		}
	}

	
	public List<Doctor> getDoctorByClinicId(Long clinicId) {
		return doctorRepostry.findByClincClinicId(clinicId);
	}

}
