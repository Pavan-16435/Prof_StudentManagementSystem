package com.book.Controller;

import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.Entity.UserRegister;
import com.book.Model.ResponseMessage;
import com.book.Service.UserRegisterService;
import com.book.Utility.Constants;

@RestController
public class UserRegisterController {
	
	@Autowired
	private UserRegisterService userRegisterService;
	
	@PostMapping("/userRegister")
	public ResponseEntity<ResponseMessage> registeringUser(@RequestBody UserRegister userRegister) {
		
		String message = userRegisterService.insertNewUser(userRegister);
		
		return ResponseEntity.ok(new ResponseMessage(HttpURLConnection.HTTP_CREATED,Constants.success,message,"user registered successfully"));
		
	}
	
}
