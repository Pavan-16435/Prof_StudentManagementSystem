package com.userAccount.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userAccount.Entity.UserRegister;


@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegister,Integer>{

}
