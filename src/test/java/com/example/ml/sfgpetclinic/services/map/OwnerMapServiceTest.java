package com.example.ml.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.ml.sfgpetclinic.model.Owner;

class OwnerMapServiceTest {

	private final Long OWNER_ID = 1l;
	private final String LAST_NAME = "LM";
	
	private OwnerMapService ownerMapService;
	
	@BeforeEach
	void setUp() throws Exception {
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
		
		Owner owner = new Owner();
		owner.setId(OWNER_ID);
		owner.setLastName(LAST_NAME);
		
		ownerMapService.save(owner);
	}

	@Test
	void testFindByLastName() {
		Owner foundOwner = ownerMapService.findByLastName(LAST_NAME);
		
		assertNotNull(foundOwner);
		assertEquals(OWNER_ID, foundOwner.getId());
	}

	@Test
	void testFindById() {
		assertEquals(OWNER_ID, ownerMapService.findById(OWNER_ID).getId());
	}

	@Test
	void testSaveExistingId() {
		Long id = 2l;
		
		Owner owner2 = new Owner();
		owner2.setId(id);
		
		Owner savedOwner = ownerMapService.save(owner2);
		
		assertEquals(id, savedOwner.getId());
	}

	@Test
	void testSaveNoId() {				
		Owner savedOwner = ownerMapService.save(new Owner());		
		assertNotNull(savedOwner.getId());
	}
	
	@Test
	void testFindAll() {
		Set<Owner> ownerSet = ownerMapService.findAll();
		assertEquals(1, ownerSet.size());
	}

	@Test
	void testDelete() {
		ownerMapService.delete(ownerMapService.findById(OWNER_ID));
		assertEquals(0, ownerMapService.findAll().size());
	}

	@Test
	void testDeleteById() {
		ownerMapService.deleteById(OWNER_ID);
		assertEquals(0, ownerMapService.findAll().size());
	}

}
