package com.example.ml.sfgpetclinic.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PetType extends BaseEntity{
	
	private String name;
	
	@OneToMany(mappedBy="petType")
	private Set<Pet> pets;	
}
