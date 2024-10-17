package com.suhil.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.suhil.entity.User;

public interface UserRepository extends  JpaRepository<User, Integer> {

}
