package com.vetclinic.controller;

import java.util.List;
import java.util.Optional;

import javax.xml.ws.soap.AddressingFeature.Responses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetclinic.entity.Clinic;
import com.vetclinic.entity.Doctor;
import com.vetclinic.entity.Pet;
import com.vetclinic.service.ClinicService;

@RestController
@RequestMapping(value = "/Clinic")
public class ClinicController {

	@Autowired
	ClinicService clinicService;

	@RequestMapping(value ="/ClinicsById", method = RequestMethod.GET)
	public ResponseEntity<Clinic> getClinicById(@RequestParam("clninicId") Long clninicId) {
		if (clninicId != null) {
			Clinic clinicResult = clinicService.getClinicById(clninicId);
			if (clinicResult!=null) {
				return new ResponseEntity<Clinic>(clinicResult, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/newClinic", method = RequestMethod.POST)
	public ResponseEntity<Responses> createClinic(@RequestBody Clinic clinic) {

		if (clinic != null) {
			clinicService.createClinic(clinic);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/getAllDoctorsByClinicId", method = RequestMethod.GET)
	public ResponseEntity<?> getallDoctorsByClinicId(@RequestParam("clinicId") Long clinicId) {
		if (clinicId != null) {
			List<Doctor> dcotorsByClinicID = clinicService.getDoctorsByClinicId(clinicId);
			return new ResponseEntity<List<Doctor>>(dcotorsByClinicID, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getAllClinicByPhoneNumberOrAddress", method = RequestMethod.GET)
	public ResponseEntity<List<Clinic>> getClinicByPhoneNumberOrAddress(@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("address") String address) {
		if (phoneNumber != null || address != null) {
			List<Clinic> clinicList = clinicService.getClinicByPhoneNumberOrAddress(phoneNumber, address);
			return new ResponseEntity<List<Clinic>>(clinicList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/assignDoctor", method = RequestMethod.POST)
	public ResponseEntity<Responses> assignDoctor
	(@RequestBody Doctor doctor, @RequestParam("clinicId") Long clinicId) {

		if (doctor != null && clinicId !=null) {
			clinicService.AssignDoctorToClinic(doctor, clinicId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
	
	
	@RequestMapping(value = "/deAssignDoctor", method = RequestMethod.POST)
	public ResponseEntity<Responses> deAssignDoctor
	(@RequestBody Doctor doctor, @RequestParam("clinicId") Long clinicId) {

		if (doctor != null && clinicId !=null) {
			clinicService.deAssignDoctorFromClinic(doctor, clinicId);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

}
