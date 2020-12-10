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

import com.vetclinic.entity.Owner;
import com.vetclinic.entity.Pet;
import com.vetclinic.service.PetService;

@RestController
@RequestMapping(value = "/pet")
public class PetController {
	@Autowired
	PetService petService;

	@RequestMapping(value = "/PetById/{petId}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Pet>> getPetById(@PathVariable("petId") Long petId) {
		Optional<Pet> petResult = petService.getOwnerById(petId);
		if (petResult.isPresent()) {
			return new ResponseEntity<Optional<Pet>>(petResult, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/newPet", method = RequestMethod.POST)
	public ResponseEntity<Responses> createNewPet(@RequestBody Pet pet) {
		if (pet != null) {
			petService.createPets(pet);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
