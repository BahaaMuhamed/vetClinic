package com.vetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class VetClinicSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VetClinicSystemApplication.class, args);
	}

}
