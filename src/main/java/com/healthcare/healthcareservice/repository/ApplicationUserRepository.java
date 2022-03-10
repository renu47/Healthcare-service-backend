package com.healthcare.healthcareservice.repository;

import java.util.Optional;

import com.healthcare.healthcareservice.Model.ApplicationUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository  extends JpaRepository<ApplicationUser, String>{
    @Query("SELECT u FROM ApplicationUser u where u.user_email like ?1")
    Optional<ApplicationUser> findByUserEmail(String email);

     

}

