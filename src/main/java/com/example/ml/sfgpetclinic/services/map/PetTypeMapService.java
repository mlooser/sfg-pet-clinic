package com.example.ml.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.PetType;
import com.example.ml.sfgpetclinic.services.PetTypeService;

@Service
@Profile({"default","map-data"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService{

}
