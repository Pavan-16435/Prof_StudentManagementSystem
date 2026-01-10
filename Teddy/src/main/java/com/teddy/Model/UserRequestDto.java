package com.teddy.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDto {
	
	@NotBlank(message = "Name should not be blank")
	@Schema(description = "Name" , example = "Name should be not be empty")
	private String firstName;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public UserRequestDto(String firstName, String lastName, String mobileNumber, String address, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.gender = gender;
	}
	public UserRequestDto() {
		super();
	}
	private String lastName;
	
	@NotBlank(message = "Enter the mobile number")
	@Schema(description = "MobileNumber" , example = "MobileNumber cannot be empty")
	private String mobileNumber;
	private String address;
	private String gender;
	

}
