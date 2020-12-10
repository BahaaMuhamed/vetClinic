package com.vetclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetclinic.entity.Doctor;
import com.vetclinic.entity.Owner;
import com.vetclinic.entity.Pet;
import com.vetclinic.reposotry.OwnerReposotry;
import com.vetclinic.reposotry.PetReposotry;

@Service
public class OwnerService {

	@Autowired
	OwnerReposotry ownerReposotry;
	
	@Autowired
	PetReposotry petReposotry;

	public void createOwners(Owner owner) {
		if (owner != null) {
			ownerReposotry.save(owner);
		}
	}

	public Optional<Owner> getOwnerById(Long ownerId) {
		Optional<Owner> owner = null;
		if (ownerId != null) {
			owner = ownerReposotry.findById(ownerId);
		}
		return owner;
	}
	
	public List<Pet> getAllPetsByOwner(Long OwnerId) {
		return petReposotry.findByOwnerOwnerId(OwnerId);
		}

}


