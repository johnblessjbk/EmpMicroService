package com.auth.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.service.entity.UserLogin;
@Repository
public interface AuthRepository extends JpaRepository<UserLogin, Long>{

}
