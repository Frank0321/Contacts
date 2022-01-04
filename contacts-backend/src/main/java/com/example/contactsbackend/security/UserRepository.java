package com.example.contactsbackend.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * FileName : UserRepository
 * CreatTime : 2022/1/4
 * Author : Frank.Chang
 * Description :
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
}
