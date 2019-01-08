package com.example.ml.sfgpetclinic.services;

import java.util.Set;

import com.example.ml.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);
		
}
