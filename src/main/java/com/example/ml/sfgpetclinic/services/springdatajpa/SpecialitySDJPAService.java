package com.example.ml.sfgpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.Speciality;
import com.example.ml.sfgpetclinic.repositories.SpecialityRepository;
import com.example.ml.sfgpetclinic.services.SpecialityService;

@Service
@Profile("spring-data-jpa")
public class SpecialitySDJPAService extends AbstractSDJPAService<Speciality, Long, SpecialityRepository> implements SpecialityService{

	public SpecialitySDJPAService(SpecialityRepository repository) {
		super(repository);
	}

}
