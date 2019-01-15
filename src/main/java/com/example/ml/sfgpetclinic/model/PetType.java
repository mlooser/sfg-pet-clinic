package com.example.ml.sfgpetclinic.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class PetType extends BaseEntity{
	
	private String name;
	
	@OneToMany(mappedBy="petType")
	private Set<Pet> pets;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}	
}
