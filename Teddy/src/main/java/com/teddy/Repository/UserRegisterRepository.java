package com.teddy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teddy.Entity.UserRegisterDetails;


@Repository
public interface UserRegisterRepository extends JpaRepository<UserRegisterDetails,Long>{

}
