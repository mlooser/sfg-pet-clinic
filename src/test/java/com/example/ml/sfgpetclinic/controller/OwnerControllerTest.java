package com.example.ml.sfgpetclinic.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.ml.sfgpetclinic.controllers.OwnerController;
import com.example.ml.sfgpetclinic.model.Owner;
import com.example.ml.sfgpetclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {

	@Mock
	private OwnerService ownerService;
	
	@InjectMocks
	private OwnerController ownerController;
	
	private MockMvc mockMvc;
	
	private Set<Owner> owners = null;
	
	@BeforeEach
	void setUp() throws Exception {
		owners = new HashSet<>();
		
		Owner o1 = new Owner();
		o1.setId(1l);
		
		Owner o2 = new Owner();
		o2.setId(1l);
		
		owners.add(o1);
		owners.add(o2);
		
		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
	}

	@Test
	void testListOwners() throws Exception {
		Mockito.when(ownerService.findAll()).thenReturn(owners);
		
		mockMvc
			.perform(MockMvcRequestBuilders.get("/owners"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.view().name("owners/index"))
			.andExpect(MockMvcResultMatchers.model().attribute("owners", Matchers.hasSize(2)));
	}

	@Test
	void testFindOwners() throws Exception {
		mockMvc
		.perform(MockMvcRequestBuilders.get("/owners/find"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("notImplemented"));
		//.andExpect(MockMvcResultMatchers.model().attribute("owners", Matchers.hasSize(2)));
	}

}
