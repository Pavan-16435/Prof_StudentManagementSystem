package com.sts.ServiceImpl;

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

}
