package com.example.ml.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="owner")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Owner extends Person{

	private String city;
	private String address;
	private String telephone;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
	private Set<Pet> pets = new HashSet<>();			
}
