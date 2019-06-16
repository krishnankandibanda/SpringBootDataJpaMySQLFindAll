package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDataJpaMySqlFindAllApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaMySqlFindAllApplication.class, args);
		System.out.println(" ..... This is FindAll Methods ...findAll(Sort),findAll(Pageable),findAll(Example)..... ");
	}

}
