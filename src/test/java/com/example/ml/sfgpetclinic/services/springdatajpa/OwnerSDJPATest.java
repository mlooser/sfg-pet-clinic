package com.example.ml.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;

import com.example.ml.sfgpetclinic.model.Owner;
import com.example.ml.sfgpetclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJPATest {

	private final String LAST_NAME = "LM";
	private final Long OWNER_ID = 1l;
	
	@Mock
	private OwnerRepository ownerRepository;
	
	@InjectMocks
	private OwnerSDJPA ownerService;
	
	private Owner sampleOwner;
	
	@BeforeEach
	void setUp() throws Exception {
		sampleOwner = new Owner();
		sampleOwner.setId(1l);
		sampleOwner.setLastName(LAST_NAME);
	}

	@Test
	final void testFindByLastName() {		
		Mockito
			.when(ownerRepository.findByLastName(Mockito.any()))
			.thenReturn(sampleOwner);
		
		Owner foundOwner = ownerService.findByLastName(LAST_NAME);
		assertNotNull(foundOwner);
		assertEquals(LAST_NAME, foundOwner.getLastName());
		
		Mockito
			.verify(ownerRepository)
			.findByLastName(Mockito.any());
	}

	@Test
	final void testFindById() {
		Mockito	
			.when(ownerRepository.findById(OWNER_ID))
			.thenReturn(Optional.of(sampleOwner));
		
		Owner foundOwner = ownerService.findById(OWNER_ID);
		assertNotNull(foundOwner);
	}

	@Test
	final void testFindByIdNotFound() {
		Mockito	
			.when(ownerRepository.findById(OWNER_ID))
			.thenReturn(Optional.empty());
		
		Owner foundOwner = ownerService.findById(OWNER_ID);
		assertNull(foundOwner);
	}
	
	@Test
	final void testSave() {
		Mockito	
			.when(ownerRepository.save(Mockito.any()))
			.thenReturn(sampleOwner);
		
		Owner savedOwner = ownerService.save(sampleOwner);
		assertNotNull(savedOwner);
	}

	@Test
	final void testFindAll() {
		Set<Owner> owners = new HashSet<>();
		
		Owner o1 = new Owner();
		o1.setId(1l);
		
		Owner o2 = new Owner();
		o1.setId(2l);
		
		owners.add(o1);
		owners.add(o2);
		
		Mockito
			.when(ownerRepository.findAll())
			.thenReturn(owners);
		
		owners = ownerService.findAll();
		assertNotNull(owners);
		assertTrue(owners.contains(o1));
		assertTrue(owners.contains(o2));
	}

	@Test
	final void testDelete() {
		ownerService.delete(sampleOwner);
		Mockito.verify(ownerRepository,VerificationModeFactory.times(1)).delete(Mockito.any());
	}

	@Test
	final void testDeleteById() {
		ownerService.deleteById(OWNER_ID);
		Mockito.verify(ownerRepository,VerificationModeFactory.times(1)).deleteById(Mockito.anyLong());
	}

}
