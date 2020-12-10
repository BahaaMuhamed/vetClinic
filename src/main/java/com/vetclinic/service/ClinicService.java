package com.vetclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetclinic.entity.Clinic;
import com.vetclinic.entity.Doctor;
import com.vetclinic.reposotry.ClinicReposotry;

@Service
public class ClinicService {

	@Autowired
	ClinicReposotry clinicReposotry;
	@Autowired
	DoctorService doctorService;

	public void createClinic(Clinic clinic) {
		if (clinic != null) {
			clinicReposotry.save(clinic);
		}
	}

	public Clinic getClinicById(Long clinicId) {
		Clinic clinic = null;
		if (clinicId != null) {
			clinic =clinicReposotry.getClinicByID(clinicId);
		}
		return clinic;
	}

	public List<Doctor> getDoctorsByClinicId(Long clinicId) {
		return doctorService.getDoctorByClinicId(clinicId);
	}

	public List<Clinic> getClinicByPhoneNumberOrAddress(String phoneNumber, String Address) {
		List<Clinic> clincByAddressOrPhone = null;
		if (phoneNumber != null || Address != null) {
			clincByAddressOrPhone = clinicReposotry.findByClinikAdderssOrClinicPhoneContaining(Address, phoneNumber);

		}

		return clincByAddressOrPhone;
	}

	public void AssignDoctorToClinic(Doctor doctorInformation, Long clinicId) {
		if (doctorInformation != null && clinicId != null) {
			Optional<Clinic> clinicResult = clinicReposotry.findById(clinicId);
			if (clinicResult.isPresent()) {
				doctorInformation.setClinc(clinicResult.get());
				doctorService.createDoctors(doctorInformation);
			}
		}

	}

	public void deAssignDoctorFromClinic(Doctor doctorInformation, Long clinicId) {
		if (doctorInformation != null && clinicId != null) {
			Optional<Clinic> clinicResult = clinicReposotry.findById(clinicId);
			if (clinicResult.isPresent()) {
				doctorInformation.setClinc(null);
				doctorService.createDoctors(doctorInformation);
				
			}
		}

	}
}
