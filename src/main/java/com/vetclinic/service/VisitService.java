package com.vetclinic.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetclinic.entity.Clinic;
import com.vetclinic.entity.Doctor;
import com.vetclinic.entity.Owner;
import com.vetclinic.entity.Pet;
import com.vetclinic.entity.Visit;
import com.vetclinic.reposotry.VisitReposotry;

@Service
public class VisitService {

	@Autowired
	VisitReposotry visitReposotry;

	public void createVisit(Pet pet, Doctor doctor, Clinic clinic) {

		if (pet != null && doctor != null && clinic != null) {
			Visit visit = new Visit();
			visit.setPet(pet);
			visit.setDoctor(doctor);
			visit.setClinic(clinic);
			visit.setDate(new Date());

			visitReposotry.save(visit);
		}
	}

	public Optional<Visit> getVisityId(Long visitId) {
		Optional<Visit> visit = null;
		if (visitId != null) {
			visit = visitReposotry.findById(visitId);
		}
		return visit;
	}
}
