package com.mohakgemini.userservice.repository;

import com.mohakgemini.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    User findFirstById(Long id);
}