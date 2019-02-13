package com.example.ml.sfgpetclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.example.ml.sfgpetclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity,ID extends Long> {

	protected Map<Long,T> map = new HashMap<>();
	
	public T findById(ID id) {
		return map.get(id);
	}
	
	public T save(T object) {
		if(object!=null) {
			if(object.getId() == null) {
				object.setId(getNextId());
			}
			
			map.put(object.getId(), object);
		} else {
			throw new RuntimeException("Object can't be null");
		}
				
		return object;
	}
	
	public Set<T> findAll(){
		return new HashSet<T>(map.values());
	}
	
	public void delete(T object) {
		map.entrySet().removeIf(e->e.getValue().equals(object));
	}
	
	public void deleteById(ID id) {
		map.remove(id);
	}
	
	private Long getNextId() {
		
		Long nextID = 1l;
		
		if(!map.isEmpty()) {
			nextID = Collections.max(map.keySet()) + 1; 
		}
		
		return nextID; 
	}
}
