package com.example.ml.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vet extends Person {
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="vet_specialities", 
		joinColumns=@JoinColumn(name="vet_id"), 
		inverseJoinColumns=@JoinColumn(name="speciality_id"))
	private Set<Speciality> specialities = new HashSet<>();
}
