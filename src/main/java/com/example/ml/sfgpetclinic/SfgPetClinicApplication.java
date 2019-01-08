package com.example.ml.sfgpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.ml.sfgpetclinic.config.PetClinicDataSource;

@SpringBootApplication
public class SfgPetClinicApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgPetClinicApplication.class, args);
		
		PetClinicDataSource ds = (PetClinicDataSource) ctx.getBean("petClinicDataSource");
		
		System.out.println(ds);		
	}

}

