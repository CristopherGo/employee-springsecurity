package com.crud.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeApplication /*implements CommandLineRunner*/ {
/**
	@Autowired
	BCryptPasswordEncoder passEncoder;

	public static void matches() {
		// Create an encoder with strength 16
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		String result = encoder.encode("myPassword");

		System.out.println("------------>   " + encoder.matches("myPasswor", result) + "\n"
				+ result);

	}
	*/
	public static void main(String[] args) {

		
		SpringApplication.run(EmployeeApplication.class, args);

	}
/* 
	@Override
	public void run(String... args) throws Exception {
		String pass1 ="user";
		String pass2 ="admin";

		System.out.println(passEncoder.encode(pass1));
		System.out.println(passEncoder.encode(pass2));
*/
	}
