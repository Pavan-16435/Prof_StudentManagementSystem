package com.sts.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sts.Entity.StudentDetails;
import com.sts.Model.ResponseMessage;
import com.sts.Model.StudentDto;
import com.sts.Service.StudentRegisterService;
import com.sts.Utility.Constants;

import jakarta.validation.Valid;

@RestController
public class StudentRegister {
	
	
	@Autowired
	private StudentRegisterService studentRegisterService;
	
	@PostMapping("/studentRegister")
	public ResponseEntity<ResponseMessage> studentRegister(@Valid @RequestBody StudentDto studentDto){
		
		if(studentDto.getEmail() == null || studentDto.getFirstName() == null || studentDto.getEmail().isEmpty() || studentDto.getFirstName().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ResponseMessage(400,Constants.failed,"please provide required fields"));
		}
		
		StudentDetails insertStudent = studentRegisterService.insertStudent(studentDto);
		
		if(insertStudent != null) {
			
			return ResponseEntity
			        .status(HttpStatus.CREATED)
			        .body(new ResponseMessage(201,Constants.success, "Student registered successfully"));
			
		}
		else {
			return ResponseEntity
			        .status(HttpStatus.BAD_REQUEST)
			        .body(new ResponseMessage(404,Constants.failure, "Student cannot be registered"));
		}

	}
	
}
