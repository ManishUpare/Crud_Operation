package com.bikkadIt.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

	private Integer UserId;

	@NotBlank
	@Size(min = 3, max = 20, message = "Invalid Username")
	private String UserName;

	@Size(min = 3, max = 20, message = "Invalid Username")
	private String Address;

	private String password;

	@Size(min = 3, max = 20, message = "Invalid Username")
	private String CompanyName;

}
