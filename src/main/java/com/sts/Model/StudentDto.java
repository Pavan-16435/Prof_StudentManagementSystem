package com.sts.Model;

import jakarta.validation.constraints.NotBlank;

public class StudentDto {
	
	@NotBlank(message = "Name cannot be empty")
	private String firstName;
	private String lastName;
	@NotBlank(message = "Name cannot be empty")
	private String email;
	@NotBlank(message = "Name cannot be empty")
	private String mobileNo;
	
	public StudentDto() {
		super();
	}
	
	@Override
	public String toString() {
		return "StudentDetails [ firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNo=" + mobileNo + "]";
	}
	
	
	public StudentDto(String firstName, String lastName, String email, String mobileNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


}
