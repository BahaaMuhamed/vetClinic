package com.vetclinic.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetclinic.entity.Clinic;
import com.vetclinic.entity.Doctor;
import com.vetclinic.entity.Owner;
import com.vetclinic.entity.Pet;
import com.vetclinic.service.OwnerService;

@RestController
@RequestMapping(value = "/owner")
public class OwnerController {
	
	@Autowired
	OwnerService ownerService;
	
	
	@RequestMapping(value = "/OwnerById/{ownerId}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Owner>> getOwnerById(@PathVariable("ownerId") Long ownerId) {
		Optional<Owner> ownerResult = ownerService.getOwnerById(ownerId);
		if(ownerResult.isPresent()){
		return new ResponseEntity<Optional<Owner>>(ownerResult, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	

	@RequestMapping(value = "/newOwner", method = RequestMethod.POST)
	public ResponseEntity<Responses> createNewOwner(@RequestBody Owner owner) {
		
			if (owner != null) {
				ownerService.createOwners(owner);;
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		 
		return new ResponseEntity<Responses>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/getAllPetsByOwnerId",method=RequestMethod.GET)
	public ResponseEntity<List<Pet>> getallPetsByOwnerId(@RequestParam ("ownerId") Long ownerID){
		if(ownerID!=null){
			List<Pet> petsList=ownerService.getAllPetsByOwner(ownerID);
			return new ResponseEntity<List<Pet>>(petsList, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
	
	
	
	

}
