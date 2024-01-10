package com.gestaocash.services;

import java.util.List;

import java.util.Optional;

//import org.springframework.security.core.userdetails.UserDetails;

import com.gestaocash.model.Users;

public interface UserService {
  void saveUser(Users user);

  List<Users> findAllUsers();

  Users findUserById(Long id);

  void updateUserById(Long id, Users updatedUser);

  void deleteUserById(Long id);
  
  Optional<Users> findByEmail(String email);
  
 
}
