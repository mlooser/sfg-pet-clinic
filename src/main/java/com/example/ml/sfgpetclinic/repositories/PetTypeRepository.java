package com.example.ml.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.ml.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
