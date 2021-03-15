package com.medication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.connection.pojo"})
@SpringBootApplication
public class MedicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicationApplication.class, args);
	}

}
