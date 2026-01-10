package com.book.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.Entity.UserRegister;
import com.book.Repository.UserRegisterRepository;
import com.book.Service.UserRegisterService;

@Service
public class UserRegisterImpl implements UserRegisterService{
	
	
	@Autowired
	private UserRegisterRepository userRegisterRepository;

	@Override
	public String insertNewUser(UserRegister userRegister) {
		
		userRegisterRepository.save(userRegister);
		
		return "user registered successfully";
	}

}
