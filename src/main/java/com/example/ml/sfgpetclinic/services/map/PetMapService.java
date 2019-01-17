package com.example.ml.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.Pet;
import com.example.ml.sfgpetclinic.services.PetService;

@Service
@Profile({"default","map-data"})
public class PetMapService extends AbstractMapService<Pet,Long> implements PetService {
	
}
