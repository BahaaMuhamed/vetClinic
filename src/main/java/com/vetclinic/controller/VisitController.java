package com.vetclinic.controller;

import java.util.Optional;

import javax.xml.ws.soap.AddressingFeature.Responses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vetclinic.entity.Clinic;
import com.vetclinic.entity.Doctor;
import com.vetclinic.entity.Pet;
import com.vetclinic.entity.Visit;
import com.vetclinic.service.VisitService;

@RestController
@RequestMapping(value = "/Visit")
public class VisitController {
	@Autowired
	VisitService visitService;

	@RequestMapping(value = "/VisitById/{visitId}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Visit>> getVisitById(@PathVariable("visitId") Long visitId) {
		Optional<Visit> visitResult = visitService.getVisityId(visitId);
		if (visitResult.isPresent()) {
			return new ResponseEntity<Optional<Visit>>(visitResult, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/newVisit", method = RequestMethod.POST)
	public ResponseEntity<Responses> createNewVisit(@RequestBody Pet pet, @RequestBody Doctor doctor,
			@RequestBody Clinic clinic) {

		if (pet != null && doctor != null && clinic != null) {
			visitService.createVisit(pet, doctor, clinic);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
