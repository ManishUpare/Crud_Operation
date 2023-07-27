package com.bikkadIt;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bikkadIt.entities.Laptop;
import com.bikkadIt.entities.User;
import com.bikkadIt.repository.UserRepository;

@SpringBootApplication
public class CruDoperationApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(CruDoperationApplication.class, args);

	}

}
