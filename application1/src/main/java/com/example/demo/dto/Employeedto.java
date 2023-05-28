package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employeedto {

	private int eid;
	
	@NotBlank(message="Employee Name couldn't be empty")
	@NotNull(message="Employee Name couldn't be null")
	private String ename;
	
	@NotBlank(message="Employee department couldn't be empty")
	@NotNull(message="Employee department couldn't be null")
	private String edept;
	
	@NotNull(message="Employee salary couldn't be null")
	private int esalary;
}
