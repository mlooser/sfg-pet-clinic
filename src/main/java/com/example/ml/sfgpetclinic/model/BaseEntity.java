package com.example.ml.sfgpetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable, IdEntity<Long>{
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
}
