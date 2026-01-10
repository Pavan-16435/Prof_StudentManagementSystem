package com.book.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.Entity.UserRegister;

@Repository
public interface UserRegisterRepository extends JpaRepository<UserRegister,Long> {

}
