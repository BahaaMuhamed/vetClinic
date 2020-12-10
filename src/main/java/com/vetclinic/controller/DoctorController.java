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

import com.vetclinic.entity.Doctor;
import com.vetclinic.service.DoctorService;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;

	@RequestMapping(value = "/DoctorById/{doctorId}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Doctor>> getDoctorById(@PathVariable("doctorId") Long doctorId) {
		Optional<Doctor> doctorResult = doctorService.getDoctorById(doctorId);
		if(doctorResult.isPresent()){
		return new ResponseEntity<Optional<Doctor>>(doctorResult, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/newDoctor", method = RequestMethod.POST)
	public ResponseEntity<Responses> createNewDoctor(@RequestBody Doctor doctor) {
		
			if (doctor != null) {
				doctorService.createDoctors(doctor);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
	}

}
