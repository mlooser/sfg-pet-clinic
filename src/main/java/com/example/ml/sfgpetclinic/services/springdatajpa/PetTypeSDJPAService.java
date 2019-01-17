package com.example.ml.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.PetType;
import com.example.ml.sfgpetclinic.repositories.PetTypeRepository;
import com.example.ml.sfgpetclinic.services.PetTypeService;

@Service
@Profile("spring-data-jpa")
public class PetTypeSDJPAService extends AbstractSDJPAService<PetType, Long, PetTypeRepository> implements PetTypeService{

	public PetTypeSDJPAService(PetTypeRepository repository) {
		super(repository);
	}

}
