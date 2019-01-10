package com.example.ml.sfgpetclinic.model;

public class Speciality extends BaseEntity{

	private String description;	
	
	public Speciality() {
		super();
	}

	public Speciality(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}
