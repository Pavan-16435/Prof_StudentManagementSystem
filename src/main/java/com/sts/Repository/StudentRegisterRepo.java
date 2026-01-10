package com.sts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sts.Entity.StudentDetails;


@Repository
public interface StudentRegisterRepo extends JpaRepository<StudentDetails,Integer>{

}
