package com.example.ml.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.Pet;
import com.example.ml.sfgpetclinic.repositories.PetRepository;
import com.example.ml.sfgpetclinic.services.PetService;

@Service
@Profile("spring-data-jpa")
public class PetSDJPAService extends AbstractSDJPAService<Pet, Long, PetRepository> implements PetService{

	public PetSDJPAService(PetRepository repository) {
		super(repository);
	}

}
