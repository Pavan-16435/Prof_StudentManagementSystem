package com.sts.Service;

import java.util.List;

import com.sts.Entity.StudentDetails;
import com.sts.Model.StudentDto;

public interface StudentRegisterService {
	
	
	StudentDetails insertStudent(StudentDto studentDto);
	
	StudentDetails updateStudent(Integer id, StudentDto studentDto);
	
	void deleteStudent(Integer id);
	
	StudentDetails getStudentById(Integer id);
	
	List<StudentDetails> getAllStudents();




}
