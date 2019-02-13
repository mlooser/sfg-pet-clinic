package com.example.ml.sfgpetclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.example.ml.sfgpetclinic.services.CrudService;

public abstract class AbstractSDJPAService<E,ID,T extends CrudRepository<E, ID>> implements CrudService<E,ID>{
	protected final T repository;
	
	public AbstractSDJPAService(T repository) {
		this.repository = repository;
	}

	@Override
	public E findById(ID id) {				
		return repository.findById(id).orElse(null);		
	}

	@Override
	public E save(E object) {
		return repository.save(object);
	}

	@Override
	public Set<E> findAll() {
		Set<E> retSet = new HashSet<>();
		repository.findAll().forEach(retSet::add);
		return retSet;
	}

	@Override
	public void delete(E object) {
		repository.delete(object);
	}

	@Override
	public void deleteById(ID id) {
		repository.deleteById(id);
	}
}
