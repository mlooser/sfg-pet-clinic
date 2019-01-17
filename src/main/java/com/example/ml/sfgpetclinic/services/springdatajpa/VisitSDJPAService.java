package com.example.ml.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.Visit;
import com.example.ml.sfgpetclinic.repositories.VisitRepository;
import com.example.ml.sfgpetclinic.services.VisitService;

@Service
@Profile("spring-data-jpa")
public class VisitSDJPAService extends AbstractSDJPAService<Visit, Long, VisitRepository> implements VisitService{

	public VisitSDJPAService(VisitRepository repository) {
		super(repository);
	}

}
