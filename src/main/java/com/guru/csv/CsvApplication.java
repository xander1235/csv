package com.guru.csv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.FileNotFoundException;


@SpringBootApplication
public class CsvApplication {


	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(CsvApplication.class, args);




	}

}
