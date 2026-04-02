package com.StudentManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentDTO {

	
	private int id;
	
	@NotBlank(message = "Name can not be blank")
    private String st_name;
	
	@Email(message="Write a proper Email")
    private String st_email;
	
	@Min(value = 16,message = "Age must be 16+")
    private int st_age;
    private String st_course;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSt_name() {
		return st_name;
	}
	public void setSt_name(String st_name) {
		this.st_name = st_name;
	}
	public String getSt_email() {
		return st_email;
	}
	public void setSt_email(String st_email) {
		this.st_email = st_email;
	}
	public int getSt_age() {
		return st_age;
	}
	public void setSt_age(int st_age) {
		this.st_age = st_age;
	}
	public String getSt_course() {
		return st_course;
	}
	public void setSt_course(String st_course) {
		this.st_course = st_course;
	}
}
