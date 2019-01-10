package com.example.ml.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.PetType;
import com.example.ml.sfgpetclinic.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService{

}
