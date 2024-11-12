package com.genpact.fd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genpact.fd.entity.User;


public interface UserRepository extends JpaRepository<User,Long>{

}
