package com.wahyu.idana.cairin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wahyu.idana.cairin.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
    @Query(value = "SELECT * FROM USERS WHERE EMAIL = ?1", nativeQuery = true)
    Users findByEmailAddress(String emailAddress);
}
