package com.suhil.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private int userId;
	
	@NotBlank(message="username should not be blank")
	private String name;
	
	@Min(18)
	@Max(50)
	private int age;
	
	@Email(message="Invalid email address")
	private String email;
	
	 @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number")
	private String mobile;
	
	@NotEmpty(message="genger should not be Empty")
	private String gender;
	
	@NotNull(message="nationality should not be null")
	private String nationality;
	

}
