package com.example.ml.sfgpetclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.ml.sfgpetclinic.model.Owner;
import com.example.ml.sfgpetclinic.model.Pet;
import com.example.ml.sfgpetclinic.services.CrudService;
import com.example.ml.sfgpetclinic.services.OwnerService;
import com.example.ml.sfgpetclinic.services.PetService;
import com.example.ml.sfgpetclinic.services.PetTypeService;

@Service
@Profile({"default","map-data"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;		
	
	public OwnerMapService(PetTypeService petTypeService, PetService petService) {
		super();
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner save(Owner object) {
		if(object.getPets()!=null) {
			object.getPets().forEach(p->{
				if(p.getPetType()!=null) {
					if(p.getPetType().getId()==null) {
						p.setPetType(petTypeService.save(p.getPetType()));
					}					
				}else {
					throw new RuntimeException("PetType is required");
				}
				
				if(p.getId()==null) {
					Pet savedPet = petService.save(p);
					p.setId(savedPet.getId());
				}
			});
		}
		
		return super.save(object);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return map
				.values()
				.stream()
				.filter(o->o.getLastName().equals(lastName))
				.findFirst()
				.orElse(null);
	}	

}
