package com.teddy.Service;

import org.springframework.stereotype.Service;

import com.teddy.Entity.UserRegisterDetails;
import com.teddy.Model.UserRequestDto;


@Service
public interface UserRegisterService {
	
	
	public UserRegisterDetails insertUserRegister(UserRequestDto userRequestDto);

}
