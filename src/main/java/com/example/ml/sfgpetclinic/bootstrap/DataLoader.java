package com.example.ml.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.ml.sfgpetclinic.model.Owner;
import com.example.ml.sfgpetclinic.model.Vet;
import com.example.ml.sfgpetclinic.services.OwnerService;
import com.example.ml.sfgpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
			
	public DataLoader(OwnerService ownerService, VetService vetService) {
		super();
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();		
		owner1.setFirstName("O_Adam");
		owner1.setLastName("O_Adamski");		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();		
		owner2.setFirstName("O_Badam");
		owner2.setLastName("O_Badamski");		
		ownerService.save(owner2);
		
		System.out.println("Owners loaded...");
		
		Vet vet1 = new Vet();		
		vet1.setFirstName("V_Adam");
		vet1.setLastName("V_Adamski");
		vetService.save(vet1);
		
		Vet vet2 = new Vet();		
		vet2.setFirstName("V_Badam");
		vet2.setLastName("V_Badamski");
		vetService.save(vet2);
		
		System.out.println("Vets loaded...");
	}

}
