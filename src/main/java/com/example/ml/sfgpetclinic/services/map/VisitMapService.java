package com.example.ml.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.Visit;
import com.example.ml.sfgpetclinic.services.VisitService;

@Service
@Profile({"default","map-data"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService{

}
