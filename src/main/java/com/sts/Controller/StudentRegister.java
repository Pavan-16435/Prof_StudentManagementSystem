package com.sts.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
					.body(new ResponseMessage(400,Constants.failed,"please provide required fields"));
		}
		
		StudentDetails insertStudent = studentRegisterService.insertStudent(studentDto);
		
		if(insertStudent != null) {
			
			return ResponseEntity.status(HttpStatus.CREATED)
			        .body(new ResponseMessage(201,Constants.success, "Student registered successfully"));
			
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
			        .body(new ResponseMessage(404,Constants.failure, "Student cannot be registered"));
		}

	}
	
	@PutMapping("/updatedStudents/{id}")
	public ResponseEntity<ResponseMessage> updateStudent(
	        @PathVariable Integer id,
	        @RequestBody StudentDto studentDto) {

	    try {
	        StudentDetails updatedStudent = studentRegisterService.updateStudent(id, studentDto);

	        return ResponseEntity.status(HttpStatus.OK)
	                .body(new ResponseMessage(200, Constants.success, "Student updated successfully"));
	    } 
	    catch (IllegalArgumentException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(new ResponseMessage(400, Constants.failure, e.getMessage()));
	    } 
	    catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(new ResponseMessage(500, Constants.failure, "Unexpected error occurred"));
	    }
	}
	
	
	@DeleteMapping("/DeletingStudents/{id}")
	public ResponseEntity<ResponseMessage> deleteStudent(@PathVariable Integer id) {
	    try {
	        studentRegisterService.deleteStudent(id);
	        return ResponseEntity.status(HttpStatus.OK)
	                .body(new ResponseMessage(200, Constants.success, "Student deleted successfully"));
	    } 
	    catch (IllegalArgumentException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(new ResponseMessage(400, Constants.failure, e.getMessage()));
	    } 
	    catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(new ResponseMessage(500, Constants.failure, "Unexpected error occurred"));
	    }
	}

	
	
	
	@GetMapping("/findStudentsBy/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id) {
	    try {
	        StudentDetails student = studentRegisterService.getStudentById(id);
	        return ResponseEntity.status(HttpStatus.OK).body(student);
	    } 
	    catch (IllegalArgumentException e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .body(new ResponseMessage(400, Constants.failure, e.getMessage()));
	    } 
	    catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(new ResponseMessage(500, Constants.failure, "Unexpected error occurred"));
	    }
	}

	
	@GetMapping("/findAllStudents")
	public ResponseEntity<?> getAllStudents() {
	    try {
	        List<StudentDetails> students = studentRegisterService.getAllStudents();

	        if (students.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.OK)
	                    .body(new ResponseMessage(200, Constants.success, "No students available yet"));
	        }

	        return ResponseEntity.status(HttpStatus.OK).body(students);
	    } 
	    catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(new ResponseMessage(500, Constants.failure, "Unexpected error occurred"));
	    }
	}

	
	
	
}
