package com.example.ml.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.Owner;
import com.example.ml.sfgpetclinic.services.CrudService;
import com.example.ml.sfgpetclinic.services.OwnerService;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}	

}
