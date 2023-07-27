package com.bikkadIt.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Laptop {

	@Id
	private Integer laptopId;
	
	private String modelNumber;
	
	private String brand;
	
	@OneToOne
	private User user;
}
