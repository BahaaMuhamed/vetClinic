package com.vetclinic.reposotry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetclinic.entity.Pet;

@Repository
public interface PetReposotry extends JpaRepository<Pet, Long> {
	public List<Pet> findByOwnerOwnerId(Long OwnerID);
}
