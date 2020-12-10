package com.vetclinic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetclinic.entity.Owner;
import com.vetclinic.entity.Pet;
import com.vetclinic.reposotry.PetReposotry;

@Service
public class PetService {
	@Autowired
	PetReposotry petReposotry;

	public void createPets(Pet pet) {
		if (pet != null) {
			petReposotry.save(pet);
		}
	}

	public Optional<Pet> getOwnerById(Long petId) {
		Optional<Pet> pet = null;
		if (petId != null) {
			pet = petReposotry.findById(petId);
		}
		return pet;
	}
	
	public List<Pet> getAllPetsByOwnerId(Long OwnerId) {
		List<Pet> pet = null;
		if (OwnerId != null) {
			pet = petReposotry.findByOwnerOwnerId(OwnerId);
		}
		return pet;
	}
}
