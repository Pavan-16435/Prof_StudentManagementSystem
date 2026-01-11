package com.sts.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sts.Entity.StudentDetails;
import com.sts.Model.StudentDto;
import com.sts.Repository.StudentRegisterRepo;
import com.sts.Service.StudentRegisterService;

@Service
public class StudentRegisterServiceImpl implements StudentRegisterService {

	
	private StudentRegisterRepo studentRegisterRepo;
	
	public StudentRegisterServiceImpl(StudentRegisterRepo studentRegisterRepo) {
		this.studentRegisterRepo=studentRegisterRepo;
	}
	
	
	
	
	@Override
	public StudentDetails insertStudent(StudentDto studentDto) {
		
		if(studentDto == null) {
			throw new IllegalArgumentException("Student details cannot be empty");
		}
		if(studentDto.getEmail() == null || studentDto.getFirstName() == null) {
			throw new IllegalArgumentException("Name or email cannot be empty");
		}
		
		StudentDetails student = new StudentDetails();
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setEmail(studentDto.getEmail());
		student.setMobileNo(studentDto.getMobileNo());
		
		return studentRegisterRepo.save(student);
		
	}
	
	


	@Override
	public StudentDetails updateStudent(Integer id, StudentDto studentDto) {
		if (id == null || id <= 0) {
	        throw new IllegalArgumentException("Invalid student ID");
	    }

	    if (studentDto == null) {
	        throw new IllegalArgumentException("Student data cannot be null");
	    }
	    
	    StudentDetails existingStudent = studentRegisterRepo.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));
		
	    if (studentDto.getFirstName() != null && !studentDto.getFirstName().isEmpty()) {
	        existingStudent.setFirstName(studentDto.getFirstName());
	    }

	    if (studentDto.getLastName() != null && !studentDto.getLastName().isEmpty()) {
	        existingStudent.setLastName(studentDto.getLastName());
	    }
	    
	    if (studentDto.getEmail() != null && !studentDto.getEmail().isEmpty()) {
	        existingStudent.setEmail(studentDto.getEmail());
	    }

	    if (studentDto.getMobileNo() != null && !studentDto.getMobileNo().isEmpty()) {
	        existingStudent.setMobileNo(studentDto.getMobileNo());
	    }
	    
	    return studentRegisterRepo.save(existingStudent);
	}
	
	
	
	
	@Override
	public void deleteStudent(Integer id) {
	    if (id == null || id <= 0) {
	        throw new IllegalArgumentException("Invalid student ID");
	    }
	    
	    boolean exists = studentRegisterRepo.existsById(id);
	    if (!exists) {
	        throw new IllegalArgumentException("Student not found with ID: " + id);
	    }

	    studentRegisterRepo.deleteById(id);
	}
	
	
	
	
	
	@Override
	public StudentDetails getStudentById(Integer id) {
	    if (id == null || id <= 0) {
	        throw new IllegalArgumentException("Invalid student ID");
	    }

	    return studentRegisterRepo.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + id));
	}

	
	
	
	@Override
	public List<StudentDetails> getAllStudents() {
		
		
	    return studentRegisterRepo.findAll();
	}



}
