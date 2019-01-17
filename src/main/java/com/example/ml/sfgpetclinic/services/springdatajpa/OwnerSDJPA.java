package com.example.ml.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.Owner;
import com.example.ml.sfgpetclinic.repositories.OwnerRepository;
import com.example.ml.sfgpetclinic.services.OwnerService;

@Service
@Profile("spring-data-jpa")
public class OwnerSDJPA extends AbstractSDJPAService<Owner, Long, OwnerRepository> implements OwnerService{

	public OwnerSDJPA(OwnerRepository repository) {
		super(repository);
	}

	@Override
	public Owner findByLastName(String lastName) {		
		return repository.findByLastName(lastName);
	}

}
