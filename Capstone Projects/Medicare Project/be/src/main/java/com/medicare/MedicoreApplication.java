package com.medicare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class MedicoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicoreApplication.class, args);
	}

}