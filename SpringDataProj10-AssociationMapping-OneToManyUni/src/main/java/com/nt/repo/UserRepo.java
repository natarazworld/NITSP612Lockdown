package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
