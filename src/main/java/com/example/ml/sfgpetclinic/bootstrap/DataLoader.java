package com.example.ml.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.ml.sfgpetclinic.model.Owner;
import com.example.ml.sfgpetclinic.model.Pet;
import com.example.ml.sfgpetclinic.model.PetType;
import com.example.ml.sfgpetclinic.model.Speciality;
import com.example.ml.sfgpetclinic.model.Vet;
import com.example.ml.sfgpetclinic.services.OwnerService;
import com.example.ml.sfgpetclinic.services.PetTypeService;
import com.example.ml.sfgpetclinic.services.SpecialityService;
import com.example.ml.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}

	@Override
	public void run(String... args) throws Exception {		
		int count = petTypeService.findAll().size();
		if(count == 0) {
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		dog = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		cat = petTypeService.save(cat);

		System.out.println("PetType loaded...");

		Pet dog1 = new Pet();
		dog1.setName("Dog_1");
		dog1.setPetType(dog);

		Pet dog2 = new Pet();
		dog2.setName("Dog_2");
		dog2.setPetType(dog);

		Pet cat1 = new Pet();
		cat1.setName("Cat_1");
		cat1.setPetType(cat);

		Pet cat2 = new Pet();
		cat2.setName("Cat_2");
		cat2.setPetType(cat);

		Owner owner1 = new Owner();
		owner1.setFirstName("O_Adam");
		owner1.setLastName("O_Adamski");
		owner1.setAddress("O_Address");
		owner1.setCity("O_City");
		owner1.setTelephone("O_123123");
		owner1.getPets().add(dog1);
		owner1.getPets().add(cat1);
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("O_Badam");
		owner2.setLastName("O_Badamski");
		owner2.setAddress("O_Address");
		owner2.setCity("O_City");
		owner2.setTelephone("O_123123");
		owner2.getPets().add(dog2);
		owner2.getPets().add(cat2);
		ownerService.save(owner2);

		System.out.println("Owners loaded...");

		Speciality s1 = specialityService.save(new Speciality("Radiology"));
		Speciality s2 = specialityService.save(new Speciality("Surgery"));
		Speciality s3 = specialityService.save(new Speciality("Dentistry"));

		Vet vet1 = new Vet();
		vet1.setFirstName("V_Adam");
		vet1.setLastName("V_Adamski");
		vet1.getSpeciality().add(s1);
		vet1.getSpeciality().add(s2);
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("V_Badam");
		vet2.setLastName("V_Badamski");
		vet2.getSpeciality().add(s2);
		vet2.getSpeciality().add(s3);
		vetService.save(vet2);

		System.out.println("Vets loaded...");
	}

}
