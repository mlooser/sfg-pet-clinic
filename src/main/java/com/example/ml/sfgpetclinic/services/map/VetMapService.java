package com.example.ml.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.Vet;
import com.example.ml.sfgpetclinic.services.SpecialityService;
import com.example.ml.sfgpetclinic.services.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	private SpecialityService specialityService;

	public VetMapService(SpecialityService specialityService) {
		super();
		this.specialityService = specialityService;
	}

	@Override
	public Vet save(Vet object) {
		object.getSpeciality().forEach(s -> {
			if (s.getId() == null) {
				s.setId(specialityService.save(s).getId());
			}
		});

		return super.save(object);
	}
}
