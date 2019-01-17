package com.example.ml.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.Vet;
import com.example.ml.sfgpetclinic.repositories.VetRepository;
import com.example.ml.sfgpetclinic.services.VetService;

@Service
@Profile("spring-data-jpa")
public class VetSDJPAService extends AbstractSDJPAService<Vet, Long, VetRepository> implements VetService{

	public VetSDJPAService(VetRepository repository) {
		super(repository);
	}

	
}
