package com.example.ml.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.Speciality;
import com.example.ml.sfgpetclinic.services.SpecialityService;

@Service
@Profile({"default","map-data"})
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService{

}
