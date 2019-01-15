package com.example.ml.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.ml.sfgpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long>{

}
