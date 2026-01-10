package com.teddy.Controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teddy.Entity.UserRegisterDetails;
import com.teddy.Model.ResponseMessage;
import com.teddy.Model.UserRequestDto;
import com.teddy.Service.UserRegisterService;
import com.teddy.utility.Constants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@Tag(name = "UserRegisterDetails", description = "Registering the users")

public class UserRegisterController {
	
	@Autowired
	private UserRegisterService userRegisterService;
	@Operation(summary = "Registering" , description = "Registering the users to notes")
	@ApiResponses({
		@ApiResponse(responseCode = "201" , description = "User created successfully"),
		@ApiResponse(responseCode = "400" , description = "User failed to Register"),
		@ApiResponse(responseCode = "500" , description = "Internal server error")
	})
	@PostMapping("/userregister")
	public ResponseEntity<ResponseMessage> userRegister(@RequestBody UserRequestDto userRequestDto){
		
		try {
			if(userRequestDto.getFirstName() == null || userRequestDto.getFirstName().isEmpty() || userRequestDto.getMobileNumber() == null || userRequestDto.getMobileNumber().isEmpty()) {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_REQUEST,Constants.failed,"Please dont keep the fields empty or null"));
			}
			UserRegisterDetails userRegister = userRegisterService.insertUserRegister(userRequestDto);
			if(userRegister != null) {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED,Constants.success,"Registered successfully"));
			}
			else {
				return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_BAD_METHOD,Constants.failure,"Registration failed"));
			}
		}
		catch(Exception e) {
			return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_INTERNAL_ERROR,Constants.failed,"Internal server error"));
		}
	
		
		
	}

}
