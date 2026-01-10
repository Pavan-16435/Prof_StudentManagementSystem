package com.userAccount.Controller;

import java.net.HttpURLConnection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userAccount.Entity.UserRegister;
import com.userAccount.Service.UserRegisterService;
import com.userAccount.model.ResponseMessage;

@RestController
public class UserRegisterController {
	
	private UserRegisterService userRegisterService;
	
	public UserRegisterController(UserRegisterService userRegisterService) {
		this.userRegisterService = userRegisterService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<ResponseMessage> registerUser(@RequestBody UserRegister userRegister) {
		
		UserRegister savedUser = userRegisterService.registeringUser(userRegister);

		return ResponseEntity
		    .status(HttpStatus.CREATED).body(new ResponseMessage(HttpURLConnection.HTTP_CREATED,"success","User saved successfully",savedUser));


		
	}
	

}
